package com.teammansasung.careerbookapi.config.auth;

import com.teammansasung.careerbookapi.config.auth.dto.SessionUser;
import com.teammansasung.careerbookapi.domain.company.dto.SessionCompany;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Component
public class LoginCompanyArgumentResolver implements HandlerMethodArgumentResolver {
    private final HttpSession httpSession;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        boolean isLoginCompanyAnnotation = parameter.getParameterAnnotation(LoginCompany.class) != null;
        boolean isCompanyClass = SessionCompany.class.equals(parameter.getParameterType());
        return isLoginCompanyAnnotation && isCompanyClass;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter,
                                  ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest,
                                  WebDataBinderFactory binderFactory) throws Exception {
        return httpSession.getAttribute("company");
    }
}
