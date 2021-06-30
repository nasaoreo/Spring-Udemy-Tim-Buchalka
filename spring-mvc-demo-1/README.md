# Description

![image](https://user-images.githubusercontent.com/81736440/123907937-a6742380-d9b1-11eb-8f06-d5872869abd8.png)

1. Request comes from the client(browser)
2. Container loads the DispatcherServlet as per the <load-on-startup> instruction in web.xml
3. DispatcherServlet intercepts the request and examines the URL pattern of the request as a provided in <url-pattern> in web.xml
4. DispatcherServlet routes the request to WelcomeController since it has a handler method doWelcome() with @RequestMapping of “/Welcome”
5. Handler constructs the model or data welcomeMessage and sets it up with the help of WelcomeService injected by container after reading the bean declaration in the config file springMvcDemo-servlet.xml
6. WelcomeController returns the view name welcomeNew which in turns is resolved by InternalResourceViewResolver declared in springMvcDemo-servlet.xml with the required prefix and suffix. Ultimately the InternationalResoruceViewResolver makes an internal call to RequestDispatcher to forward the request to the resolved view welcomeNew.jsp
7. WelcomeNew.jsp dynamically renders the model welcomeMessage after doing the necessary processing
