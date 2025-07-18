package com.cx.cxpicturebackend.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cx.cxpicturebackend.model.dto.user.UserModifyPassWord;
import com.cx.cxpicturebackend.model.dto.user.UserQueryRequest;
import com.cx.cxpicturebackend.model.vo.LoginUserVO;
import com.cx.cxpicturebackend.model.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cx.cxpicturebackend.model.vo.UserVO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
* @author 86178
* @description 针对表【user(用户)】的数据库操作Service
* @createDate 2025-06-01 23:20:58
*/
public interface UserService extends IService<User> {

    /**
     * 验证用户输入的验证码是否正确
     *
     * @param userInputCaptcha 用户输入的验证码
     * @param serververifycode 服务器端存储的加密后的验证码
     * @return 如果验证成功返回true，否则返回false
     */
    boolean validateCaptcha(String userInputCaptcha, String serververifycode);

    Map<String, String> getCaptcha();

    /**
     * 用户注册
     * @param email
     * @param userPassword
     * @param checkPassword
     * @param code
     * @return
     */
    long userRegister(String email, String userPassword, String checkPassword, String code);

    /**
     * 用户登录
     *
     * @param userAccount  用户账户
     * @param userPassword 用户密码
     * @param request
     * @return 脱敏后的用户信息
     */
    LoginUserVO userLogin(String userAccount, String userPassword, HttpServletRequest request);

    /**
     * 获取加密后的密码
     *
     * @param userPassword
     * @return
     */
    String getEncryptPassword(String userPassword);

    /**
     * 获取当前登录用户
     *
     * @param request
     * @return
     */
    User getLoginUser(HttpServletRequest request);

    boolean changePassword(UserModifyPassWord userModifyPassWord, HttpServletRequest request);


    /**
     * 获得脱敏后的登录用户信息
     *
     * @param user
     * @return
     */
    LoginUserVO getLoginUserVO(User user);

    /**
     * 获得脱敏后的用户信息
     *
     * @param user
     * @return
     */
    UserVO getUserVO(User user);

    /**
     * 获得脱敏后的用户信息列表
     *
     * @param userList
     * @return 脱敏后的用户列表
     */
    List<UserVO> getUserVOList(List<User> userList);

    /**
     * 用户注销
     *
     * @param request
     * @return
     */
    boolean userLogout(HttpServletRequest request);

    /**
     * 获取查询条件
     * @param userQueryRequest
     * @return
     */
    QueryWrapper<User> getQueryWrapper(UserQueryRequest userQueryRequest);

    /**
     * 是否为管理员
     *
     * @param user
     * @return
     */
    boolean isAdmin(User user);

    /**
     * 用户兑换会员（会员码兑换）
     */
    boolean exchangeVip(User user, String vipCode);

    /**
     * 发送邮箱验证码
     * @param email 邮箱
     * @param type 验证码类型
     * @param request HTTP请求
     */
    void sendEmailCode(String email, String type, HttpServletRequest request);

    /**
     * 修改绑定邮箱
     * @param newEmail 新邮箱
     * @param code 验证码
     * @param request HTTP请求
     * @return 是否修改成功
     */
    boolean changeEmail(String newEmail, String code, HttpServletRequest request);

    /**
     * 判断是否是登录态
     */
    User isLogin(HttpServletRequest request);
}
