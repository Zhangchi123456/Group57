package org.Hotel.common.config;

import java.io.File;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XMLReader {
	
	private static IPConfig ipconfig;
		
		/**
		 * 从配置文件中读取参数并保存到Config类中;
		 * 
		 */
		public static IPConfig loadipconfig(String filename) {
			if (ipconfig == null)
				ipconfig = getconfig(filename);
			return ipconfig;
	    }
		
		private static IPConfig getconfig(String filename) {
			IPConfig config = new IPConfig();
			try {
				File f = new File(filename);
				if (!f.exists()) {
					System.out.println("  Error : IPConfig file doesn't exist!");
					System.exit(1);
				}
				SAXReader reader = new SAXReader();
				Document doc = reader.read(f);
				Element root = doc.getRootElement();
				Element data;
				Iterator<?> itr = root.elementIterator("IPconfig");
				data = (Element) itr.next();

				config.IP = data.elementText("IPaddress").trim();
				config.PORT = data.elementText("Port").trim();

			} catch (Exception ex) {
				ex.printStackTrace();
			}
			return config;

	}

}
