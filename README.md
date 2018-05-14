Save Pledge Viewtool
=================================================
A plugin for dotCMS that adds a "save pledge" viewtool that allows the front-end to save directly into the Pledge Structure object without having to use Ajax or REST.

Installation
-----
* Navigate to the dotCMS Dynamic plugins page: "System" > "Dynamic Plugins"
* Click on "Upload plugin" and select the .jar file located in the "build/jar/" folder

Compatibility
-----
Known to work with 2.5+.

Usage
-----
* put your data from post into variables
#set($firstname = $request.getParameter("_first_name-first"))
#set($lastname = $request.getParameter("_first_name-last"))

Call your object with the required variables populated as below:
save(String $pledgeStatus, String $patronName, String $address, String $city, String $state, String $zipcode, String $telephone, String $emailAddress, String $totalPledge, String $premium,  String $onAir,  String $useName,  String $contactMe,  String $favorites,  String $addlcomments)

Content is checked into CMS.

Building
--------
* Install Gradle (if not already installed)
* gradle jar # dotcms-savepledgetool
