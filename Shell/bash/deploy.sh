#!/bin/bash
cp /cluster/efuuxii/commonContainerConfiguration.json /usr/local/pgngn/tomcat-server-163.110/webapps/launchpad/commonContainerConfiguration.json
cp /cluster/efuuxii/timgui-frontend.war /usr/local/pgngn/tomcat-server-163.110/webapps/timgui-frontend.war
chown actadm:activation /usr/local/pgngn/tomcat-server-163.110/webapps/timgui-frontend.war
chmod 640 /usr/local/pgngn/tomcat-server-163.110/webapps/timgui-frontend.war
sleep 7s
chown -R actadm:activation /usr/local/pgngn/tomcat-server-163.110/webapps/timgui-frontend
