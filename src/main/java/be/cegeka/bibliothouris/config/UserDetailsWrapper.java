package be.cegeka.bibliothouris.config;

import be.cegeka.bibliothouris.domain.users.User;
import be.cegeka.bibliothouris.domain.users.UserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class UserDetailsWrapper implements UserDetails {

    private User user;

    public UserDetailsWrapper(User user){
        this.user = user;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()     {

        ArrayList<GrantedAuthority> userRoles = new ArrayList<>();
        for (UserRole r: user.getRoles()) {
            userRoles.add(new SimpleGrantedAuthority("ROLE_" + r.getRole()));
        }
        return userRoles;
//        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getInss();}

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
