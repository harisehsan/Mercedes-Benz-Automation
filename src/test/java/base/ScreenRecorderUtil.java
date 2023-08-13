package base;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import getProperties.ScreenRecGetProperty;
import org.monte.media.Format;
import org.monte.media.FormatKeys.MediaType;
import org.monte.media.Registry;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;

import static org.monte.media.AudioFormatKeys.*;
import static org.monte.media.VideoFormatKeys.*;

/** This class is used to perform video recording for the test **/

public class ScreenRecorderUtil extends ScreenRecorder {
 static ScreenRecGetProperty screenRecGetProperty = new ScreenRecGetProperty();
 public static ScreenRecorder screenRecorder;
 public String name;
public static   String file_info;
 public ScreenRecorderUtil(GraphicsConfiguration cfg, Rectangle captureArea, Format fileFormat,
   Format screenFormat, Format mouseFormat, Format audioFormat, File movieFolder, String name)
     throws IOException, AWTException {
  super(cfg, captureArea, fileFormat, screenFormat, mouseFormat, audioFormat, movieFolder);
  this.name = name;
 }

 @Override
 /** This method is used to create a movie file in a movie directory  **/
 protected File createMovieFile(Format fileFormat) throws IOException {

  if (!movieFolder.exists()) {
   movieFolder.mkdirs();
  } else if (!movieFolder.isDirectory()) {
   throw new IOException("\"" + movieFolder + screenRecGetProperty.notADirectory());
  }
  /** define the characteristics of the movie file format and name **/
  SimpleDateFormat dateFormat = new SimpleDateFormat(screenRecGetProperty.dateFormat());
  file_info = (name + "-" + dateFormat.format(new Date()) + "." + Registry.getInstance().getExtension(fileFormat));
  return new File(movieFolder,
          screenRecGetProperty.video()+screenRecGetProperty.mp4());
 }

 /** This method is used to start the recording of web browser which executes the test**/
 public static void startRecord(String methodName) throws Exception {
  File file = new File(screenRecGetProperty.directory());
  Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
  int width = screenSize.width;
  int height = screenSize.height;

  /** Managing the recording screen window size **/
  Rectangle captureSize = new Rectangle(convertToInteger(screenRecGetProperty.zeroValue()), convertToInteger(screenRecGetProperty.zeroValue()), width, height);

  /** Getting the required attributes for screen recording **/
  GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().
    getDefaultScreenDevice()
    .getDefaultConfiguration();
  screenRecorder = new ScreenRecorderUtil(gc, captureSize,
    new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
    new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
      CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE, DepthKey, convertToInteger(screenRecGetProperty.twentyFourValue()), FrameRateKey,
      Rational.valueOf(convertToInteger(screenRecGetProperty.fifteenValue())), QualityKey, convertToFloat(screenRecGetProperty.oneFloatValue()) , KeyFrameIntervalKey, convertToInteger(screenRecGetProperty.fifteenValue()) * convertToInteger(screenRecGetProperty.sixtyValue())),
    new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, screenRecGetProperty.black(), FrameRateKey, Rational.valueOf(convertToInteger(screenRecGetProperty.thirtyValue()))),
    null, file, methodName);
  screenRecorder.start();
 }

 /** This method is used to stop the recording**/
 public static ScreenRecorder stopRecord() throws Exception {
  screenRecorder.stop();
  return screenRecorder;
 }

 /** Convert the string value into integer**/
 private static int convertToInteger(String value) throws IOException {
  return (Integer.parseInt(value));
 }

 /** Convert the string value into float**/
 private static float convertToFloat(String value) throws IOException {
  return (Float.parseFloat(value));
 }

}
