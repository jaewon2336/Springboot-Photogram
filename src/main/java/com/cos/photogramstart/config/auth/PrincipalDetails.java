package com.cos.photogramstart.config.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cos.photogramstart.domain.user.User;

import lombok.Data;

@Data
public class PrincipalDetails implements UserDetails { // 모두 true가 떨어져야 정상적인 로그인 가능

    private static final long serialVersionUID = 1L;

    private User user;

    public PrincipalDetails(User user) {
        this.user = user;
    }

    // 권한이 하나가 아닐 수 있기 때문에 컬렉션 타입
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collector = new ArrayList<>();

        // 메서드를 파라미터로 전달하기 위해 람다식 사용
        collector.add(() -> {
            return user.getRole();
        });

        return collector;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() { // 계정 만료 확인
        return true;
    }

    @Override
    public boolean isAccountNonLocked() { // 계정 금지 확인
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() { // 비밀번호 만기 확인
        return true;
    }

    @Override
    public boolean isEnabled() { // 계정 활성화 확인
        return true;
    }

}
