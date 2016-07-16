[![Build Status](https://travis-ci.org/spdeepak/Stackoverflow.svg?branch=master)](https://travis-ci.org/spdeepak/Stackoverflow) [![Coverage Status](https://coveralls.io/repos/github/spdeepak/Stackoverflow/badge.svg?branch=master)](https://coveralls.io/github/spdeepak/Stackoverflow?branch=master)
[![Dependencies](https://www.versioneye.com/user/projects/5786a0576edb08004191dfcc/badge.svg?style=flat)](https://www.versioneye.com/user/projects/5786a0576edb08004191dfcc)
[![Build status](https://ci.appveyor.com/api/projects/status/op9ydudro5954frb?svg=true)](https://ci.appveyor.com/project/spdeepak/stackoverflow)
# Stackoverflow Java API (Under Construction)

Stackoverflow Rest API - https://api.stackexchange.com/docs

# Usage
1. To get a particular number of Answers with in a specified date, order, and Sort order.
	Create a AnswerInitializer object and pass it to AnswerItemURLGenerator to get a JsonURL and pass the same to AnswerItem's Fetcher class and get the list of AnswerItem's
