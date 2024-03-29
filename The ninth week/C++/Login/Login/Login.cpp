
// Login.cpp : 定义应用程序的类行为。
//

#include "stdafx.h"
#include "Login.h"
#include "LoginDlg.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#endif


// CLoginApp

BEGIN_MESSAGE_MAP(CLoginApp, CWinApp)
	ON_COMMAND(ID_HELP, &CWinApp::OnHelp)
END_MESSAGE_MAP()


// CLoginApp 构造

CLoginApp::CLoginApp()
{
	// 支持重新启动管理器
	m_dwRestartManagerSupportFlags = AFX_RESTART_MANAGER_SUPPORT_RESTART;

	// TODO: 在此处添加构造代码，
	// 将所有重要的初始化放置在 InitInstance 中
}


// 唯一的一个 CLoginApp 对象

CLoginApp theApp;


// CLoginApp 初始化

BOOL CLoginApp::InitInstance()
{
	// 如果一个运行在 Windows XP 上的应用程序清单指定要
	// 使用 ComCtl32.dll 版本 6 或更高版本来启用可视化方式，
	//则需要 InitCommonControlsEx()。否则，将无法创建窗口。
	INITCOMMONCONTROLSEX InitCtrls;
	InitCtrls.dwSize = sizeof(InitCtrls);
	// 将它设置为包括所有要在应用程序中使用的
	// 公共控件类。
	InitCtrls.dwICC = ICC_WIN95_CLASSES;
	InitCommonControlsEx(&InitCtrls);

	CWinApp::InitInstance();


	AfxEnableControlContainer();

	// 创建 shell 管理器，以防对话框包含
	// 任何 shell 树视图控件或 shell 列表视图控件。
	CShellManager *pShellManager = new CShellManager;

	// 标准初始化
	// 如果未使用这些功能并希望减小
	// 最终可执行文件的大小，则应移除下列
	// 不需要的特定初始化例程
	// 更改用于存储设置的注册表项
	// TODO: 应适当修改该字符串，
	// 例如修改为公司或组织名
	SetRegistryKey(_T("应用程序向导生成的本地应用程序"));
	while (TRUE)  
	{  
		CLoginDlg dlg;
		m_pMainWnd = &dlg;
		//INT_PTR nReturn = dlg.DoModal();
		int nReturn = dlg.DoModal();//返回IDOK或IDCANCEL。如果返回的是IDCANCEL，则要调用WindowsCommDlgExtendedError函数来确定是否发生了一个错误。IDOK和IDCANCEL都是常量，它表明用户选择的是OK按钮还是Cancel按钮  
		if (nReturn == IDOK)
		{
			//HWND login_Hwnd = GetDlgItem(dlg,IDD_LOGIN_DIALOG);  
			//CString str_User = dlg.m_strUser;  
			//CString str_Password = dlg.m_strPassword;
			CString str_User;
			CString str_Password;
			str_User.Format(dlg.m_strUser);
			str_Password.Format(dlg.m_strPassword);
			if(!(str_User == "admin" && str_Password == "123456")){//如果用户名密码不是admin/admin，则报错，提示重新输入，直至正确为止。
				MessageBox(NULL,_T("用户ID或密码错误！\n 请重新输入！"),_T("登录失败！"),MB_OKCANCEL|MB_ICONERROR);
				if(IDOK == MessageBox(NULL,_T("用户ID或密码错误！\n 请重新输入！"),_T("登录失败！"),MB_OKCANCEL|MB_ICONERROR))  
					continue;
				else  
					return FALSE;  
			}  
			else  
				break;  
			// TODO: 在此放置处理何时用
			//  “确定”来关闭对话框的代码
		}
		if (nReturn == IDCANCEL)
		{
			// TODO: 在此放置处理何时用
			//  “取消”来关闭对话框的代码
		}
	}
	// 删除上面创建的 shell 管理器。
		if (pShellManager != NULL)
		{
			delete pShellManager;
		}
	// 由于对话框已关闭，所以将返回 FALSE 以便退出应用程序，
	//  而不是启动应用程序的消息泵。
	return FALSE;
}

