#!/bin/bash
if [ `hostname` = "SC-1" ]
then
    scp /usr/local/pgngn/tomcat-server-163.110/webapps/timgui-frontend/timgui/Timgui.js SC-2:/usr/local/pgngn/tomcat-server-163.110/webapps/timgui-frontend/timgui
elif [ `hostname` = "SC-2" ]
then
    scp /usr/local/pgngn/tomcat-server-163.110/webapps/timgui-frontend/timgui/Timgui.js SC-1:/usr/local/pgngn/tomcat-server-163.110/webapps/timgui-frontend/timgui
else
    echo "`hostname` is not SC-1 or SC-2, not transfer"
fi
