package uicheck.uicheck;

import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.sun.tools.javac.util.Assert;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;


public class ImageCheck {

	public static void main(String[] args) throws IOException {
		// System.out.println("hi");
	
		System.setProperty("webdriver.chrome.driver", "F://Divya//wrkspace//VivekPrj//uicheck//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String baseUrl = "https://www.google.co.in/";
		driver.manage().window().maximize();
		driver.navigate().to(baseUrl);
		driver.findElement(By.name("q")).click();
		driver.findElement(By.name("q")).sendKeys("k");
			    File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);			
				FileUtils.copyFile(screenshot, new File("F:\\Divya\\wrkspace\\VivekPrj\\uicheck\\GoogleOutput.jpg"));
				File fileInput = new File("F:\\Divya\\wrkspace\\VivekPrj\\uicheck\\Positive.jpg");
		        File fileOutPut = new File("F:\\Divya\\wrkspace\\VivekPrj\\uicheck\\GoogleOutput.jpg");

		        BufferedImage bufferfileInput = ImageIO.read(fileInput);
		        DataBuffer dbufferfileInput = bufferfileInput.getData().getDataBuffer();
		        int sizefileInput = dbufferfileInput.getSize();                     
		        BufferedImage bufferfileOutPut = ImageIO.read(fileOutPut);
		        DataBuffer datafileOutPut = bufferfileOutPut.getData().getDataBuffer();
		        int sizefileOutPut = datafileOutPut.getSize();
		        Boolean matchFlag = true;
		        if(sizefileInput == sizefileOutPut) {
		        	
		           for(int i=0; i<sizefileInput; i++) {
		                 if(dbufferfileInput.getElem(i) != datafileOutPut.getElem(i)) {
		                       matchFlag = false;
		                       break;
		                 }
		            }
		        }
		        
		        else {                           
		            matchFlag = false;
		         Assert.check(matchFlag, "Images are not same");    
		      }
				
				
				
				driver.quit();
				
			
}
}
