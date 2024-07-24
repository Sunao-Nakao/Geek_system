package com.example.demo.controller;

import java.util.Optional;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.constant.MessageConst;
import com.example.demo.constant.SignupMessage;
import com.example.demo.constant.UrlConst;
import com.example.demo.entity.Users;
import com.example.demo.form.SignupForm;
import com.example.demo.service.SignupService;
import com.example.demo.util.AppUtil;

import lombok.RequiredArgsConstructor;

/** ユーザー登録画面 コントローラー **/
@Controller
@RequiredArgsConstructor
public class SignupController {
	
	/** ユーザー登録画面 サービス **/
	private final SignupService service;
	
	/** メッセージソース **/
	private final MessageSource messageSource;
	
	
	/** ユーザ登録画面　**
	 * @param model モデル
	 * @param form 入力情報
	 * @return 表示画面
	 */
	@GetMapping(UrlConst.SIGNUP)
	public String view(Model model, SignupForm form) {
		return "signup";
	}
	
	/** ユーザ登録　**
	 * @param model モデル
	 * @param form 入力情報
	 * @param form 入力チェック結果
	 */
	@PostMapping(UrlConst.SIGNUP)
	public String signup(Model model, @Validated SignupForm form, BindingResult bdResult) {
		if(bdResult.hasErrors()) {
			editGuideMessage(model, MessageConst.FORM_ERROR, true);
			return "signup";
		}
		
		var usersOpt = service.resistUsers(form);
		var signupMessage = judgeMessageKey(usersOpt);
		editGuideMessage(model, signupMessage.getMessageId(),signupMessage.isError());
		if (signupMessage.isError()) {
	        return "signup";
	    }
		return "signup";
	}
	
	
	/** 画面表示するガイドメッセージを設定　**
	 * @param model モデル
	 * @param messageIdメッセージID
	 * @param isError エラー有無
	 */
	private void editGuideMessage(Model model, String messageId, boolean isError) {
		var message = AppUtil.getMessage(messageSource, messageId);
		model.addAttribute("message",message);
		model.addAttribute("isError",isError);
	}
	
	
	/** ユーザ情報登録結果のメッセージキーを判断する **
	 * @param usersOpt ユーザ登録結果(登録済みだった場合はEmpty)
	 * @return メッセージキー
	 */
	private SignupMessage judgeMessageKey(Optional<Users> usersOpt) {
		if(usersOpt.isEmpty()) {
			return SignupMessage.EXISTED_LOGIN_EMAIL;
		} else {
			return SignupMessage.SUCCEED;
		}
	}
}
