       package presentation.presentationController;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import BusinessLogicService.impl.RMIHelper;
import presentation.userui.AlertBox;

public class RMIConnection implements Runnable{
	
	public RMIConnection(){
		RMIConnection.number=0;
		new Thread(this).start();
	}
	
	
	public static int number=0;
	
	
	@Override
	public void run() {

		while(true){
			try {
				Thread.sleep(1000);
				Object service = (Object) Naming.lookup("rmi://"+RMIHelper.IP+":"+RMIHelper.PORT+"/"+"ConnectionDataService");
				number++;
			} catch (InterruptedException | MalformedURLException | RemoteException | NotBoundException e) {
				System.out.println("Connection Failed!");
				AlertBox alt = new AlertBox();
				alt.display("连接失败，尝试重新连接");
				break;
			}
		}
	}

}
