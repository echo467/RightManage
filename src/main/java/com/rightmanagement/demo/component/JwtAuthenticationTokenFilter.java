package com.rightmanagement.demo.component;

import com.rightmanagement.demo.common.utils.JwtTokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * JWT登录授权过滤器
 *
 * 在用户名和密码校验前添加的过滤器，
 * 如果请求中有jwt的token且有效，
 * 会取出token中的用户名，
 * 然后调用SpringSecurity的API进行登录操作。
 */
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {// ensure that filter is only applied once per request
    private static final Logger LOGGER= LoggerFactory.getLogger(JwtAuthenticationTokenFilter.class);
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead")
    private String tokenHead;
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {
         String authHeader = request.getHeader(this.tokenHeader);
         if(authHeader!=null && authHeader.startsWith(this.tokenHead)){
             //substring(start,stop) 方法用于提取字符串中介于两个指定下标之间的字符
             //start必须，stop不必须
             // 此处用于提取Bearer后的token
             String authToken = authHeader.substring(this.tokenHead.length());

             String username = jwtTokenUtil.getUserNameFromToken(authToken);
             LOGGER.info("checking username:{}",username);
             //在登陆过程中，spring security会创建一个Authentication对象
             // 放入SecurityContextHolder
             // 用来自动保存当前访问者的信息
             if(username!=null && SecurityContextHolder.
                     getContext().getAuthentication()==null){
                 UserDetails userDetails=this.userDetailsService.loadUserByUsername(username);
                 if(jwtTokenUtil.validateToken(authToken,userDetails)){
                     //当在页面中输入用户名和密码之后首先会进入到UsernamePasswordAuthenticationToken验证
                     //然后生成的Authentication会被交由AuthenticationManager来进行管理
                     UsernamePasswordAuthenticationToken authentication
                             =new UsernamePasswordAuthenticationToken
                             (userDetails,null,userDetails.getAuthorities());//主体，证书，权限

                     authentication.setDetails(new WebAuthenticationDetailsSource()
                             .buildDetails(request));
                     LOGGER.info("authenticated user:{}",username);
                     SecurityContextHolder.getContext().setAuthentication(authentication);
                 }
             }
         }
         filterChain.doFilter(request,response);
    }
}
