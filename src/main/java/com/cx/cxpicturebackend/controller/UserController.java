package com.cx.cxpicturebackend.controller;

import com.cx.cxpicturebackend.common.BaseResponse;
import com.cx.cxpicturebackend.common.ResultUtils;
import com.cx.cxpicturebackend.exception.ErrorCode;
import com.cx.cxpicturebackend.exception.ThrowUtils;
import com.cx.cxpicturebackend.model.dto.UserRegisterRequest;
import com.cx.cxpicturebackend.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 用户注册
     * @param userRegisterRequest
     * @return
     */
    @PostMapping("/register")
    public BaseResponse userRegister(@RequestBody UserRegisterRequest userRegisterRequest) {
        ThrowUtils.throwIf(userRegisterRequest == null, ErrorCode.PARAMS_ERROR);
        long result = userService.userRegister(
                userRegisterRequest.getUserAccount(),
                userRegisterRequest.getUserPassword(),
                userRegisterRequest.getCheckPassword()
        );
        return ResultUtils.success(result);
    }
}
