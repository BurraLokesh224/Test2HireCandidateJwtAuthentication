package com.QBarterIT.Test2Hire.Candidate.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;

import java.util.Random;
import java.util.Set;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.QBarterIT.Test2Hire.Candidate.exception.ResourceNotFoundException;
import com.QBarterIT.Test2Hire.Candidate.message.request.ForgetPassword;
import com.QBarterIT.Test2Hire.Candidate.message.request.LoginForm;
import com.QBarterIT.Test2Hire.Candidate.message.request.SignUpForm;
import com.QBarterIT.Test2Hire.Candidate.message.request.Sslcform;
import com.QBarterIT.Test2Hire.Candidate.model.Candidate;
import com.QBarterIT.Test2Hire.Candidate.model.Sslc;
import com.QBarterIT.Test2Hire.Candidate.repository.CandidateRepository;
import com.QBarterIT.Test2Hire.Candidate.repository.SslcRepository;
import com.QBarterIT.Test2Hire.Candidate.security.jwt.JwtProvider;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class CandidateSignupAndLogin {

	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	CandidateRepository userRepository;
	@Autowired
	SslcRepository sslcRepository;
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	JwtProvider jwtProvider;
	@Autowired
	public JavaMailSender JavaMailSender;

	@PostMapping("/signup")
	public ResponseEntity<String> registerUser(@Valid @RequestBody SignUpForm signUpRequest, Sslcform sslcRequest,
			MultipartFile file) throws ResourceNotFoundException {

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return new ResponseEntity<String>("Fail -> Email is already in use!", HttpStatus.BAD_REQUEST);
		}
		Sslc ssc = new Sslc();
		Candidate user = new Candidate(signUpRequest.getId(), signUpRequest.getFirstName(), signUpRequest.getLastName(),
				signUpRequest.getFatherName(), signUpRequest.getFatherOccupation(), signUpRequest.getDateOfBirth(),
				signUpRequest.getGender(), signUpRequest.getAadharNumber(), signUpRequest.getPanNumber(),
				signUpRequest.getAddress(), signUpRequest.getCity(), signUpRequest.getState(),
				signUpRequest.getPincode(), signUpRequest.getPhoneNumber(), signUpRequest.getAlternatePhoneNumber(),
				signUpRequest.getEmail(), encoder.encode(signUpRequest.getPassword()),
				encoder.encode(signUpRequest.getConfirmPassword()));
		if ("MALE".equals(signUpRequest.getGender())) {
		} else if ("FEMALE".equals(signUpRequest.getGender())) {
		} else if ("OTHERS".equals(signUpRequest.getGender())) {
		} else {
			new RuntimeException("Fail! -> Cause: Invalid Gender.");
			return ResponseEntity.ok().body("Invalid Gender");
		}

		ssc.setBoard(sslcRequest.getBoard());
		ssc.setSchoolName(sslcRequest.getSchoolName());
		ssc.setLocation(sslcRequest.getLocation());
		ssc.setYearOfPassing(sslcRequest.getYearOfPassing());
		ssc.setPercentage(sslcRequest.getPercentage());
		ssc.setFilesslc(sslcRequest.getFilesslc());

		ssc = signUpRequest.getSslc();
		ssc.setCandidate(user);
		user.setSslc(ssc);

		userRepository.save(user);
		return ResponseEntity.ok().body("User registered successfully!");
	}

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		@SuppressWarnings("unused")
		String jwt = jwtProvider.generateJwtToken(authentication);
		return ResponseEntity.ok("User login successfully!");
	}
	/*
	 * @PostMapping("/forgetpassword") public ResponseEntity<String>
	 * registerUser(@Valid @RequestBody ForgetPassword resetRequest) {
	 * SimpleMailMessage message = new SimpleMailMessage(); if
	 * (userRepository.existsByEmail(resetRequest.getEmail())) {
	 * message.setTo(resetRequest.getEmail());
	 * message.setSubject("simple mail seder "); otp = OTPGenerate.generateotp();
	 * Calendar cl = Calendar.getInstance(); long otpgenTime = cl.getTimeInMillis();
	 * message.setText(" otp send to your email account = " + otp);
	 * JavaMailSender.send(message); return new ResponseEntity<String>
	 * ("email exist successfully.....  we send reset password to your email id",
	 * HttpStatus.FOUND); } return ResponseEntity.ok().
	 * body("Invalid email does not exist, Please provide correct email"); }
	 */

	public static int generateOTP() {
		Random random = new Random();
		int otp = 1000 + random.nextInt(9000);
		return otp;
	}

	/*
	 * @PostMapping("/otpcampar") public ResponseEntity<String>
	 * otpvalidate(@Valid @RequestBody Otpsystem otpsystem) { Calendar cl =
	 * Calendar.getInstance(); if ((otp) == otpsystem.getOtp()) { if
	 * (cl.getTimeInMillis() - otpgenTime <= (500000)) { return new
	 * ResponseEntity<String>(" otp validation successfully", HttpStatus.FOUND); } }
	 * return ResponseEntity.ok().body("User otp invalid !"); }
	 */

	@PutMapping("/customers/{email}")
	public ResponseEntity<String> updateCustomer(@PathVariable("email") String email,

			@RequestBody SignUpForm resetpassword) {
		System.out.println("Update Customer with ID = " + email + "...");
		Candidate customerData = userRepository.findByEmail(email);
		if (customerData.isPresent()) {
			customerData.setPassword(encoder.encode(resetpassword.getPassword()));
			customerData.setConfirmPassword(encoder.encode(resetpassword.getConfirmPassword()));
			userRepository.save(customerData);
			return ResponseEntity.ok().body("your new password created successfully!");
		}
		return new ResponseEntity<>("something went wrong", HttpStatus.NOT_FOUND);
	}

	@DeleteMapping(value = "/deleteproduct/{id}")
	public void deletepfofile(@PathVariable("id") Long id) {
		userRepository.deleteById(id);

	}

	/*
	 * @GetMapping(path = "/card", produces = "application/json") public
	 * ResponseEntity<Map<String, String>> registeruser(@RequestParam("id") long id)
	 * { Map<String, String> map = new HashMap<String, String>(); try { User usr =
	 * userRepository.findById(id);
	 * 
	 * @SuppressWarnings("unused") Date date = new Date(); map.put("firstname",
	 * usr.getFirstname()); map.put("lastname", usr.getLastname()); String
	 * cardnumber = this.GetRanadomdigit(); map.put("Randomnumber", cardnumber);
	 * String cardcvv = this.randomCvv(); map.put("cvv", cardcvv);
	 * map.put("expiry date", this.expirydate());
	 * 
	 * Card card = new Card(); card.setExpiryDate(this.expirydate());
	 * card.setCvv(cardcvv); card.setRandomAccess(cardnumber);
	 * 
	 * userRepository.save(usr); cardrepository.save(card);
	 * 
	 * 
	 * }catch (Exception e) { throw new
	 * ResponseStatusException(HttpStatus.NOT_FOUND, "card details not found", e); }
	 * return new ResponseEntity<Map<String, String>>(map, HttpStatus.OK); }
	 */
	/*
	 * public String GetRanadomdigit() { Random rands = new Random(); long ran =
	 * (long) (rands.nextDouble() * 10000000000000000L); StringBuilder builder = new
	 * StringBuilder(String.valueOf(ran)); return builder.insert(4, " ").insert(9,
	 * " ").insert(14, " ").toString(); }
	 * 
	 * public String randomCvv() { Random rands = new Random(); int cvv =
	 * (rands.nextInt(900) + 100); return String.valueOf(cvv); }
	 * 
	 * public String CurrentDate() { DateFormat time = new
	 * SimpleDateFormat("MM/yy"); Date date = new Date(); String pressentdate =
	 * time.format(date); return pressentdate; }
	 * 
	 * public String expirydate() {
	 * 
	 * @SuppressWarnings("unused") Date date = new Date(); Calendar cal =
	 * Calendar.getInstance(); // cal.setTime(date); cal.add(Calendar.YEAR, 2); //
	 * java.util.Date expirationDate = cal.getTime(); Date edate = cal.getTime();
	 * SimpleDateFormat time = new SimpleDateFormat("MM/YY"); String expiredate =
	 * time.format(edate); // return String.valueOf(expirationDate); return
	 * expiredate;
	 * 
	 * }
	 */
}
