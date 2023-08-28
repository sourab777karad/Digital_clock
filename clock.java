import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.Calendar;
import javax.swing.JFrame;
import java.text.SimpleDateFormat;
import javax.swing.JLabel;

class MyFrame extends JFrame {
    Calendar calendar;
    SimpleDateFormat timeFormat;
    SimpleDateFormat dayFormat;
    SimpleDateFormat dateFormat;

    JLabel timeLabel;
    JLabel dayLabel;
    JLabel dateLabel;
    String time;
    String day;
    String date;

    MyFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("My Clock Program");
        this.setLayout(new FlowLayout());
        this.setSize(400, 250);
        this.setResizable(false);

        timeFormat = new SimpleDateFormat("hh:mm:ss a");
        dayFormat = new SimpleDateFormat("EEEE");
        dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Arial", Font.BOLD, 50));
        timeLabel.setForeground(new Color(46, 134, 193)); // Blue color
        timeLabel.setOpaque(false);

        dayLabel = new JLabel();
        dayLabel.setFont(new Font("Arial", Font.BOLD, 40));
        dayLabel.setForeground(new Color(231, 76, 60)); // Red color
        dayLabel.setOpaque(false);

        dateLabel = new JLabel();
        dateLabel.setFont(new Font("Arial", Font.BOLD, 50));
        dateLabel.setForeground(new Color(39, 174, 96)); // Green color
        dateLabel.setOpaque(false);

        this.add(timeLabel);
        this.add(dayLabel);
        this.add(dateLabel);
        this.setVisible(true);
        setTime();
    }

    public void setTime() {
        while (true) {
            time = timeFormat.format(Calendar.getInstance().getTime());
            timeLabel.setText(time);
            day = dayFormat.format(Calendar.getInstance().getTime());
            dayLabel.setText(day);
            date = dateFormat.format(Calendar.getInstance().getTime());
            dateLabel.setText(date);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class clock {
    public static void main(String[] args) {
        new MyFrame();
    }
}
