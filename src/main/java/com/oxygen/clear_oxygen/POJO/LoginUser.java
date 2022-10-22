package com.oxygen.clear_oxygen.POJO;

import com.oxygen.clear_oxygen.PO.SysUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Data
@NoArgsConstructor
public class LoginUser implements UserDetails {

    private SysUser user;

    private List<String> permissions;

    public LoginUser(SysUser user, List<String> permissions) {
        this.user = user;
        this.permissions = permissions;
    }

    /**
     * 配置权限信息
     * @return 权限列表
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        // 把permissions中string类型的权限信息封装成simpleGrantedAuthority对象
        List<GrantedAuthority> newList = new ArrayList<>();
        for (String permission : permissions) {
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority(permission);
            newList.add(authority);

        }
        return newList;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUserName();
    }

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
