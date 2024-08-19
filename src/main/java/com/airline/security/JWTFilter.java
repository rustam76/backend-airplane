// package com.airline.security;


// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;
// import org.springframework.web.filter.OncePerRequestFilter;


// import io.jsonwebtoken.io.IOException;
// import jakarta.servlet.FilterChain;
// import jakarta.servlet.ServletException;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;

// @Service
// public class JWTFilter extends OncePerRequestFilter {

//     private static final String AUTHORIZATION_HEADER = "Authorization";
//     private static final String BEARER = "Bearer";
//     @Autowired
//     private JWTUtils jwtUtils;

//     // @Autowired
//     // private UserService userService;


//     @Override
//     protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

      
//         String token = request.getHeader(AUTHORIZATION_HEADER);
//         if (token != null && token.isBlank() && token.startsWith(BEARER)) {
//             String jwt = token.substring(7);

//             if (jwt == null) {
//                 try {
                    
//                     response.sendError(HttpServletResponse.SC_UNAUTHORIZED, jwt);
//                 } catch (IOException e) {
//                     // TODO: handle exception
//                     e.printStackTrace();
//                 }
//             } else {
//                 try {
//                     Boolean user = jwtUtils.validateToken(jwt);
//                     if (user != null) {
//                         request.setAttribute("username", user);
//                         filterChain.doFilter(request, response);
//                     }
//                 } catch (Exception e) {
//                     // TODO: handle exception
//                     response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
//                 }
//             }

//         }
//         filterChain.doFilter(request, response);
   

//     }
    
// }
