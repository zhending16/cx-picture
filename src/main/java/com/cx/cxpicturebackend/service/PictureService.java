package com.cx.cxpicturebackend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cx.cxpicturebackend.model.dto.picture.PictureUploadRequest;
import com.cx.cxpicturebackend.model.entity.Picture;
import com.cx.cxpicturebackend.model.entity.User;
import com.cx.cxpicturebackend.model.vo.PictureVO;
import org.springframework.web.multipart.MultipartFile;

/**
* @author 86178
* @description 针对表【picture(图片)】的数据库操作Service
* @createDate 2025-06-03 23:54:56
*/
public interface PictureService extends IService<Picture> {

    /**
     * 上传图片
     *
     * @param multipartFile
     * @param pictureUploadRequest
     * @param loginUser
     * @return
     */
    PictureVO uploadPicture(MultipartFile multipartFile,
                            PictureUploadRequest pictureUploadRequest,
                            User loginUser);

}
