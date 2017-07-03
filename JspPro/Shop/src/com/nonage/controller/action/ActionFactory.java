package com.nonage.controller.action;

import com.nonage.action.Action;
import com.nonage.action.indexAction;
import com.nonage.admin.controller.action.AdminIndexAction;
import com.nonage.admin.controller.action.AdminMemberListAction;
import com.nonage.admin.controller.action.AdminOrderListAction;
import com.nonage.admin.controller.action.AdminOrderSaverAction;
import com.nonage.admin.controller.action.AdminProductDetailAction;
import com.nonage.admin.controller.action.AdminProductListAction;
import com.nonage.admin.controller.action.AdminProductUpdateFormAction;
import com.nonage.admin.controller.action.AdminProductWriteAction;
import com.nonage.admin.controller.action.AdminProductWriteFormAction;
import com.nonage.admin.controller.action.AdminQnaDetailAction;
import com.nonage.admin.controller.action.AdminQnaListAction;
import com.nonage.admin.controller.action.AdminQnaResaveAction;
import com.nonage.admin.controller.action.AdminProductUpdateAction;


//요청이 들어 왓을 때 어떤 액션 객체가 동작해야 하는지 판단하여 객체를 생성해주는 일응 담당

public class ActionFactory {
	private static ActionFactory instance = new ActionFactory();
	public ActionFactory(){
		super();
	}
	
	public static ActionFactory getInstance(){
		return instance;
	}
	
	public Action getAction(String command){
		Action action=null;
		System.out.println("ActionFactory :" + command);
		
		if(command.equals("index")){
			action = new indexAction(); 
		}else if(command.equals("product_detail")){
			action = new ProductDetailAction();
		}else if(command.equals("catagory")){
			action = new ProductKindAction();
		}else if(command.equals("contract")){
			action = new ContractAction();
		}else if(command.equals("join_form")){
			action = new JoinFormAction();
		}else if(command.equals("id_check_form")){
			action = new idCheckFormAction();
		}else if(command.equals("find_zip_num")){
			action = new FindZipNumAction();
		}else if(command.equals("join")){
			action = new JoinAction();
		}else if(command.equals("login_form")){
			action = new LoginFormAction();
		}else if(command.equals("login")){
			action = new LoginAction();
		}else if(command.equals("logout")){
			action = new LogoutAction();
		}else if(command.equals("cart_insert")){
			action = new CartInsertAction();
		}else if(command.equals("cart_list")){
			action = new CartListAction();
		}else if(command.equals("cart_delete")){
			action = new CartDeleteAction();
		}else if(command.equals("order_insert")){
			action = new OrderInsertAction();
		}else if(command.equals("order_list")){
			action = new OrderListAction();
		}else if(command.equals("mypage")){
			action = new MypageAction();
		}else if(command.equals("order_detail")){
			action = new OrderDetailAction();
		}/*else if(command.equals("order_all")){
			action = new OrderAllAction();
		}*/else if(command.equals("qna_list")){
			action = new QnaListAction();
		}else if(command.equals("qna_write_form")){
			action = new QnaWriteFormAction();
		}else if(command.equals("qna_write")){
			action = new QnaWriteAction();
		}else if(command.equals("qna_view")){
			action = new QnaViewAction();
		}else if(command.equals("admin_login_form")){
			action = new AdminIndexAction();
		}else if(command.equals("admin_login")){
			action = new AdminLoginAction();
		}else if(command.equals("admin_logout")){
			action = new AdminLogoutAction();
		}else if(command.equals("admin_product_list")){
			action = new AdminProductListAction();
		}else if(command.equals("admin_product_write_form")){
			action = new AdminProductWriteFormAction();
		}else if(command.equals("admin_product_write")){
			action = new AdminProductWriteAction();
		}else if(command.equals("admin_product_detail")){
			action = new AdminProductDetailAction();
		}else if(command.equals("admin_product_update_form")){
			action = new AdminProductUpdateFormAction();
		}else if(command.equals("admin_product_update")){
			action = new AdminProductUpdateAction();
		}else if(command.equals("admin_order_list")){
			action = new AdminOrderListAction();
		}else if(command.equals("admin_order_save")){
			action = new AdminOrderSaverAction();
		}else if(command.equals("admin_member_list")){
			action = new AdminMemberListAction();
		}else if(command.equals("admin_qna_list")){
			action = new AdminQnaListAction();
		}else if(command.equals("admin_qna_detail")){
			action = new AdminQnaDetailAction();
		}else if(command.equals("admin_qna_repsave")){
			action = new AdminQnaResaveAction();
		}
		return action;
	}
}
