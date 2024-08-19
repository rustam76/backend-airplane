// package com.airline.security;

// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.stereotype.Service;

// import com.auth0.jwt.JWT;
// import com.auth0.jwt.JWTVerifier;
// import com.auth0.jwt.algorithms.Algorithm;
// import com.auth0.jwt.exceptions.JWTVerificationException;
// import com.auth0.jwt.interfaces.DecodedJWT;



// @Service
// public class JWTUtils {
    
//     @Value("${jwt.secret}")
//     private String secret;

//     public String generateToString(String username) {
//         return JWT.create()
//                   .withSubject("Airline")
//                   .withClaim("username", username)
//                   .withIssuedAt(java.time.Instant.now())
//                   .withIssuer("Airline")
//                   .withExpiresAt(java.time.Instant.now().plusSeconds(3600))
//                   .sign(Algorithm.HMAC512(secret.getBytes()));

//     }

//     public boolean validateToken(String token) throws JWTVerificationException {

//             JWTVerifier verifier =  JWT.require(Algorithm.HMAC512(secret.getBytes()))
//                                         .withSubject("Airline")
//                                         .withIssuer("Airline").build();
            
//                                         DecodedJWT decodedJWT =  verifier.verify(token);

//             return decodedJWT.getClaim("username").asString() != null;
//         }

// }
