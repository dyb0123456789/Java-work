
// Login.cpp : ����Ӧ�ó��������Ϊ��
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


// CLoginApp ����

CLoginApp::CLoginApp()
{
	// ֧����������������
	m_dwRestartManagerSupportFlags = AFX_RESTART_MANAGER_SUPPORT_RESTART;

	// TODO: �ڴ˴���ӹ�����룬
	// ��������Ҫ�ĳ�ʼ�������� InitInstance ��
}


// Ψһ��һ�� CLoginApp ����

CLoginApp theApp;


// CLoginApp ��ʼ��

BOOL CLoginApp::InitInstance()
{
	// ���һ�������� Windows XP �ϵ�Ӧ�ó����嵥ָ��Ҫ
	// ʹ�� ComCtl32.dll �汾 6 ����߰汾�����ÿ��ӻ���ʽ��
	//����Ҫ InitCommonControlsEx()�����򣬽��޷��������ڡ�
	INITCOMMONCONTROLSEX InitCtrls;
	InitCtrls.dwSize = sizeof(InitCtrls);
	// ��������Ϊ��������Ҫ��Ӧ�ó�����ʹ�õ�
	// �����ؼ��ࡣ
	InitCtrls.dwICC = ICC_WIN95_CLASSES;
	InitCommonControlsEx(&InitCtrls);

	CWinApp::InitInstance();


	AfxEnableControlContainer();

	// ���� shell ���������Է��Ի������
	// �κ� shell ����ͼ�ؼ��� shell �б���ͼ�ؼ���
	CShellManager *pShellManager = new CShellManager;

	// ��׼��ʼ��
	// ���δʹ����Щ���ܲ�ϣ����С
	// ���տ�ִ���ļ��Ĵ�С����Ӧ�Ƴ�����
	// ����Ҫ���ض���ʼ������
	// �������ڴ洢���õ�ע�����
	// TODO: Ӧ�ʵ��޸ĸ��ַ�����
	// �����޸�Ϊ��˾����֯��
	SetRegistryKey(_T("Ӧ�ó��������ɵı���Ӧ�ó���"));
	while (TRUE)  
	{  
		CLoginDlg dlg;
		m_pMainWnd = &dlg;
		//INT_PTR nReturn = dlg.DoModal();
		int nReturn = dlg.DoModal();//����IDOK��IDCANCEL��������ص���IDCANCEL����Ҫ����WindowsCommDlgExtendedError������ȷ���Ƿ�����һ������IDOK��IDCANCEL���ǳ������������û�ѡ�����OK��ť����Cancel��ť  
		if (nReturn == IDOK)
		{
			//HWND login_Hwnd = GetDlgItem(dlg,IDD_LOGIN_DIALOG);  
			//CString str_User = dlg.m_strUser;  
			//CString str_Password = dlg.m_strPassword;
			CString str_User;
			CString str_Password;
			str_User.Format(dlg.m_strUser);
			str_Password.Format(dlg.m_strPassword);
			if(!(str_User == "admin" && str_Password == "123456")){//����û������벻��admin/admin���򱨴���ʾ�������룬ֱ����ȷΪֹ��
				MessageBox(NULL,_T("�û�ID���������\n ���������룡"),_T("��¼ʧ�ܣ�"),MB_OKCANCEL|MB_ICONERROR);
				if(IDOK == MessageBox(NULL,_T("�û�ID���������\n ���������룡"),_T("��¼ʧ�ܣ�"),MB_OKCANCEL|MB_ICONERROR))  
					continue;
				else  
					return FALSE;  
			}  
			else  
				break;  
			// TODO: �ڴ˷��ô����ʱ��
			//  ��ȷ�������رնԻ���Ĵ���
		}
		if (nReturn == IDCANCEL)
		{
			// TODO: �ڴ˷��ô����ʱ��
			//  ��ȡ�������رնԻ���Ĵ���
		}
	}
	// ɾ�����洴���� shell ��������
		if (pShellManager != NULL)
		{
			delete pShellManager;
		}
	// ���ڶԻ����ѹرգ����Խ����� FALSE �Ա��˳�Ӧ�ó���
	//  ����������Ӧ�ó������Ϣ�á�
	return FALSE;
}

