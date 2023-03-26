### HOW TO USE
1. Default run:

`mvn clean verrify`

2. Run with specific browser (chrome is default):

`mvn clean install -D"BROWSER=firefox"`

3. Run by tags:

`mvn verify -D"cucumber.filter.tags=@EXAM1 or @EXAM2"`


### SEE Report
1. Extent report: ExtentReports

![image](https://user-images.githubusercontent.com/67543695/227770875-51a2bcc3-db72-40a9-ada1-9d3a05916ecf.png)

2. Cucumber report: target/cucumber-reports/cucumber-reports.html

![image](https://user-images.githubusercontent.com/67543695/227770926-2ecaf387-bbbc-4019-84cb-16e3164447b4.png)

3. TestNG report: target/surefire-reports/index.html

![image](https://user-images.githubusercontent.com/67543695/227770959-c7982e11-fe9f-4593-a0e4-cb9c2751b8b8.png)

4. PDF Report

![image](https://user-images.githubusercontent.com/67543695/227770980-a8d0f91a-8802-4e47-85a4-7e5b657cab72.png)

5. Logging file: myapp.log

![image](https://user-images.githubusercontent.com/67543695/227770999-feda5b16-9e6a-463a-8115-093a131186cb.png)

