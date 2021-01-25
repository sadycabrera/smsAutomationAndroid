import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestSendSms
{
    @Test
    public void setUpSms() throws MalformedURLException, InterruptedException {

        //TouchAction touchAction = new TouchAction(androidDriver);
        //txt Fecha
        //android.widget.TextView


        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName","DIIBKF99LZPNN7UG");
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appPackage","com.android.mms");
        // desiredCapabilities.setCapability("appActivity","com.android.mms.ui.ComposeMessageActivity");
        desiredCapabilities.setCapability("appActivity","com.android.mms.ui.BootActivity");
        //desiredCapabilities.setCapability("avd", "Nexus_5X_API_R");
        AndroidDriver<AndroidElement> androidDriver= new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4724/wd/hub"),desiredCapabilities);
        Thread.sleep(1000);
        //androidDriver.sendSMS("999979962", "Quieres aprender about qa automation");// SOLO EMULATOR
        /*REDACTAR Y ENVIAR MENSAJE*/
        //androidDriver.findElement(By.id("com.android.mms:id/recipients_editor")).sendKeys("999979962");
        //androidDriver.findElement(By.id("com.android.mms:id/embedded_text_editor")).sendKeys("HOLA SOY QA AUTOMATION FULL STACK");
        //androidDriver.findElement(By.id("com.android.mms:id/send_button_sms")).click();
        //Thread.sleep(5000);
        //scroll(androidDriver);
        //scroll(androidDriver);
        //scroll(androidDriver);
        //androidDriver.findElement(By.xpath("//android.widget.ListView/android.widget.RelativeLayout[12]/android.widget.FrameLayout/android.widget.QuickContactBadge")).click();
        AndroidElement txtMensaje= androidDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.ListView/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView"));
        String mensaje=txtMensaje.getText();
        txtMensaje.click();
        Thread.sleep(7000);



        DesiredCapabilities desiredCapabilities1 = new DesiredCapabilities();
        desiredCapabilities1.setCapability("deviceName","DIIBKF99LZPNN7UG");
        desiredCapabilities1.setCapability("platformName", "Android");
        // desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");

        // desiredCapabilities.setCapability(MobileCapabilityType.VERSION, "6.0");
        desiredCapabilities1.setCapability("appPackage","com.mibanco.bancamovil.qa");
        // desiredCapabilities.setCapability("appActivity","com.android.mms.ui.ComposeMessageActivity");
        desiredCapabilities1.setCapability("appActivity","com.mibanco.bancamovil.MainActivity");
        //desiredCapabilities.setCapability("avd", "Nexus_5X_API_R");

        AndroidDriver<AndroidElement> androidDriver1= new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),desiredCapabilities1);
       androidDriver1.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        androidDriver1.findElement(By.xpath("//android.view.ViewGroup[@content-desc='onboardingscreen_gotologinscreen']")).click();

        Thread.sleep(5000);
        androidDriver1.quit();
        Thread.sleep(5000);
        androidDriver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        AndroidElement ultimoMesaje=androidDriver.findElement(By.xpath("\t\n" +
                "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[4]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView"));
        System.out.println(ultimoMesaje.getText());
        androidDriver.quit();


        //androidDriver1.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"onboardingscreen_gotologinscreen\"]")).click();

        //android.view.ViewGroup[@content-desc="onboardingscreen_gotologinscreen"]
        System.out.println("DE NUEVO"+mensaje);

    }
    //SE AGREGA EL METODO SCROLL
    public  void scroll(AndroidDriver<AndroidElement> androidDriver) throws InterruptedException {

        Dimension dimension= androidDriver.manage().window().getSize();
        int x= dimension.getWidth()/2;
        int starY=(int) (dimension.getHeight()*0.8);
        int ednY= (int) (dimension.getHeight()*0.2);

        TouchAction action = new TouchAction(androidDriver);
        action.press(PointOption.point(x,starY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(x,ednY))
                .release().perform();
    }
}

