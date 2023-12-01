package javaClass.io;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class UrlExample {

	public static void main(String[] args) throws Exception {
		String str_url="https://www.baidu.com/s?ie=utf-8&f=8&rsv_bp=1&rsv_idx=1&tn=baidu&wd=%E6%B1%89%E8%AF%AD&fenlei=256&rsv_pq=0xc5bc7b9c0077ebef&rsv_t=59728%2B9NCYqIipIKF9SvzZGbiKhT6SzVz5CkoS%2Fra3DC16SHymkYrm%2FWwjkl&rqlang=en&rsv_enter=1&rsv_dl=tb&rsv_sug3=19&rsv_sug1=8&rsv_sug7=101&rsv_sug2=0&rsv_btype=i&inputT=14879&rsv_sug4=15559";

		
		URL url=new URL(str_url);
		InputStream is=url.openStream();//byte 단위(한국어는 2바이트임, 읽어올때 1바이트 씩 읽어서 깨짐)
		
		while(true) {
			int ch=is.read();
			if(ch==-1) break;
			System.out.print((char)ch);
		}
	}

}
