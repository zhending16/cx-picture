package com.cx.cxpicturebackend.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cx.cxpicturebackend.annotation.AuthCheck;
import com.cx.cxpicturebackend.common.BaseResponse;
import com.cx.cxpicturebackend.common.DeleteRequest;
import com.cx.cxpicturebackend.common.ResultUtils;
import com.cx.cxpicturebackend.constant.UserConstant;
import com.cx.cxpicturebackend.exception.BusinessException;
import com.cx.cxpicturebackend.exception.ErrorCode;
import com.cx.cxpicturebackend.exception.ThrowUtils;
import com.cx.cxpicturebackend.model.dto.UserLoginRequest;
import com.cx.cxpicturebackend.model.dto.UserRegisterRequest;
import com.cx.cxpicturebackend.model.dto.picture.PictureUploadRequest;
import com.cx.cxpicturebackend.model.dto.user.UserAddRequest;
import com.cx.cxpicturebackend.model.dto.user.UserQueryRequest;
import com.cx.cxpicturebackend.model.dto.user.UserUpdateRequest;
import com.cx.cxpicturebackend.model.entity.User;
import com.cx.cxpicturebackend.model.vo.LoginUserVO;
import com.cx.cxpicturebackend.model.vo.PictureVO;
import com.cx.cxpicturebackend.model.vo.UserVO;
import com.cx.cxpicturebackend.service.PictureService;
import com.cx.cxpicturebackend.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/picture")
public class PictureControllerController {

    @Resource
    private PictureService pictureService;

    @Resource
    private UserService userService;

    /**
     * 上传图片
     * @param multipartFile
     * @param pictureUploadRequest
     * @param request
     * @return
     */
    @PostMapping("/upload")
    @AuthCheck(mustRole = UserConstant.ADMIN_ROLE)
    public BaseResponse<PictureVO> uploadPicture(
            @RequestPart("file") MultipartFile multipartFile,
            PictureUploadRequest pictureUploadRequest,
            HttpServletRequest request) {
        User loginUser = userService.getLoginUser(request);
        PictureVO pictureVO = pictureService.uploadPicture(multipartFile, pictureUploadRequest, loginUser);
        return ResultUtils.success(pictureVO);
    }


}
