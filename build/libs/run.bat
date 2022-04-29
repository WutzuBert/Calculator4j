@echo off
if "%1" == "h" goto begin 
mshta vbscript:createobject("wscript.shell").run("""%~nx0"" h",0)(window.close)&&exit 
:begin 
D:\AlibabaDragonWell\jdk8u312-b01\bin\java.exe -jar D:\untitled22\build\libs\untitled22-1.0-SNAPSHOT.jar