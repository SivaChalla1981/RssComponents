#!/bin/bash

mvn test -DfailIfNoTests=false -Dbrowser=chrome -Denvironment=local -Dtest=RunCucumber
