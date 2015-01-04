#!/usr/bin/env bash

debug=0

mvn="/bvo/apps/maven/apache-maven-3.2.1/bin/mvn --settings /Users/pro/Documents/workspace_st/settings.xml --batch-mode --debug"
gradle="gradle --daemon"

function check () {
	if [ ! -d "$1" ]
	then
	   echo "ERROR - $1 - is not a directory"
	else 
		cmd_name=""
		cmd=""
		expected_result="BUILD SUCCESS"
		if [[ -f "$1/build.gradle" && ( "gradle" = "$2" || "" = "$2" ) ]]
		then
			cmd_name="gradle"
			cmd="$gradle"
		else
			if [[ -f "$1/pom.xml" && ( "mvn" = "$2" || "" = "$2" ) ]]
			then
				cmd_name="mvn"
				cmd="$mvn"
			fi
		fi
		if [ "" = "$cmd" ]
		then
		   echo "ERROR - $1 - neither pom.xml nor build.gradle"
	    else
			if [ -f "$1/${cmd_name}_expected_result.txt" ]
			then
				expected_result=$(cat "$1/${cmd_name}_expected_result.txt")
			fi
			echo -n "$cmd_name:	"
			if [ "1" = "$debug" ]
			then
				rm -f "$1/$cmd_name.out"
				r=$(cd "$1"; $cmd test 2>&1 | tee "$cmd_name.out" | grep --max-count=1 --count "$expected_result")
			else
				r=$(cd "$1"; $cmd test 2>&1  | grep --max-count=1 --count "$expected_result")
			fi
			if [ "0" -eq "$r" ];
			then
				echo "ERROR - $1 - results different from expected : '$expected_result'"
			else
				echo "OK    - $1"
			fi
		fi 
	fi
}

for i in $(ls); do
	if [ -d "$i" ]
	then
		if [ "" = "$1" ]
		then
			check "$i" ""
		else
			if [ "both" = "$1" ]
			then
				check "$i" "mvn"
				check "$i" "gradle"
			else
				if [ "clean" = "$1" ]
				then
					rm -fr "$i/build" "$i/target" "$i/gradle.out" "$i/mvn.out" "$i/.gradle" "$i/.out" 2>&1 > /dev/null
					echo "CLEAN - $i"
				else
					check "$i" "$1"
				fi
			fi
		fi
	fi
done


    
