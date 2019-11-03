#-*- coding:utf-8 -*-
import tkinter
#change函数，如果窗口属性被改变则执行
def change(event):
    win.update()
    print("(窗口位置被移动)窗口位于屏幕x轴:" + str(win.winfo_x()))
    print("(窗口位置被移动)窗口位于屏幕y轴:" + str(win.winfo_y()))
win = tkinter.Tk()
win.update()
win.bind("<Configure>",change) #绑定事件
print("窗口位于屏幕x轴:" + str(win.winfo_x()))
print("窗口位于屏幕y轴:" + str(win.winfo_y()))
win.mainloop()