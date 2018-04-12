package in.ac.iitd.openhouse.openhouseapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by mayankdubey on 07/04/18.
 */

public class FacultyCoordinator {

    String name, email, imageUrl;

    public FacultyCoordinator(String name, String email, String imageUrl) {
        this.name = name;
        this.email = email;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

//    private Bitmap decodeFile(File f){
//        try {
//            //decode image size
//            BitmapFactory.Options o = new BitmapFactory.Options();
//            o.inJustDecodeBounds = true;
//            BitmapFactory.decodeStream(new FileInputStream(f),null,o);
//
//            //Find the correct scale value. It should be the power of 2.
//            final int REQUIRED_SIZE=70;
//            int width_tmp=o.outWidth, height_tmp=o.outHeight;
//            int scale=1;
//            while(true){
//                if(width_tmp/2<REQUIRED_SIZE || height_tmp/2<REQUIRED_SIZE)
//                    break;
//                width_tmp/=2;
//                height_tmp/=2;
//                scale*=2;
//            }
//            //decode with inSampleSize
//            BitmapFactory.Options o2 = new BitmapFactory.Options();
//            o2.inSampleSize=scale;
//            return BitmapFactory.decodeStream(new FileInputStream(f), null, o2);
//        } catch (FileNotFoundException e) {}
//        return null;
//    }

//    public Bitmap getImage() {
//
////         Loader image - will be shown before loading image
//        int loader = R.drawable.f1;
//
//

//        try {
//            File f=new File(context.getFilesDir(), filename);;
//            Bitmap bitmap=null;
//            URL imageUrl = new URL(url);
//            HttpURLConnection conn = (HttpURLConnection)imageUrl.openConnection();
//            conn.setConnectTimeout(30000);
//            conn.setReadTimeout(30000);
//            conn.setInstanceFollowRedirects(true);
//            InputStream is=conn.getInputStream();
//            OutputStream os = new FileOutputStream(f);
//            Utils.CopyStream(is, os);
//            os.close();
//            bitmap = decodeFile(f);
//            return bitmap;
//        } catch (Exception ex){
//            ex.printStackTrace();
//            return null;
        }
//
//    }

