package com.rightmanagement.demo.config;

import com.rightmanagement.demo.component.JwtAuthenticationTokenFilter;
import com.rightmanagement.demo.component.RestAuthenticationEntryPoint;
import com.rightmanagement.demo.component.RestfulAccessDeniedHandler;
import com.rightmanagement.demo.entity.UmsAdmin;
import com.rightmanagement.demo.service.UmsAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.Filter;

/**
 * springSecurity 配置
 */
@Configuration
@EnableWebSecurity
//来判断用户对某个控制层的方法是否具有访问权限,也就是@preAuthorize注解
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

   @Autowired
    private UmsAdminService umsAdminService;
   @Autowired
    private RestfulAccessDeniedHandler restfulAccessDeniedHandler;
   @Autowired
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;


   @Override
     //用于配置需要拦截的url路径、jwt过滤器及出异常后的处理器
    protected void configure(HttpSecurity http) throws Exception{
             //使用Jwt,不需要csrf
       http.csrf()
               .disable()
               //使用Jwt,不需要session
               .sessionManagement()
               .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
               .and()
               .authorizeRequests()
               //antMatchers实在看不懂
               .antMatchers(HttpMethod.GET,
                       "/",
                       "/*.html",
                       "/favicon.ico",
                       "/**/*.html",
                       "/**/*.css",
                       "/**/*.js",
                       "/swagger-resources/**",
                       "v2/api-docs/**"
                       )
               .permitAll()
                //对登录注册要允许匿名访问
               .antMatchers("admin/login","admin/register")
               .permitAll()
                //  跨域请求会先进行一次options请求
               .antMatchers(HttpMethod.OPTIONS)
               .permitAll()
                //除上面外的所有请求全部需要鉴权认证
               .anyRequest()
               .authenticated();
       //禁用缓存
       http.headers().cacheControl();
       //添加Jwt filter
       http.addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
       //添加自定义未授权和未登录结果返回
       http.exceptionHandling()
               .accessDeniedHandler(restfulAccessDeniedHandler)
               .authenticationEntryPoint(restAuthenticationEntryPoint);
   }

   @Override
   //用于配置UserDetailsService和PasswordEncoder
   protected void configure(AuthenticationManagerBuilder auth)throws Exception{
       auth.userDetailsService(userDetailsService())
               .passwordEncoder(passwordEncoder());
   }

//   @Bean
//   public UserDetailsService userDetailsService(){
//       //获取登录信息
//       return username -> {
//           UmsAdmin admin = umsAdminService.getAdminByUsername(username);
//           if(admin!=null){
//               List<UmsPermission> permissionList=umsAdminService.getPermissionList(admin.getId());
//               return new AdminUserDetails(admin,permissionList);
//           }
//           throw new UsernameNotFoundException("用户名或密码错误");
//       };
//   }

   @Bean
    public PasswordEncoder passwordEncoder() {
       return new BCryptPasswordEncoder();
    }

    @Bean
    public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter() {
       return new JwtAuthenticationTokenFilter();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception{
       return super.authenticationManagerBean();
    }
}
