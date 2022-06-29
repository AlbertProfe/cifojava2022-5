package io.company.securityDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomerUserDetailService implements UserDetailsService  {
	
		@Autowired
		private CustomerRepository customerRepository;
		
		@Override
		public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			
			final Customer customer = customerRepository.findByUsername(username).get();
	        if (customer == null) {
	            throw new UsernameNotFoundException(username);
	        }
	        UserDetails user = User.withUsername(customer.getUsername()).password(customer.getPassword()).authorities("USER").build();
	        return user;
		}

}


