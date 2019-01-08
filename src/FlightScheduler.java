
import java.awt.event.ItemEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.Calendar;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Armin
 */
public class FlightScheduler extends javax.swing.JFrame {

    private BookingEntry bookingCurrentEntry;
    private WaitListEntry waitListCurrentEntry;
    private Booking booking;
    private WaitList waitList;
    private Flights flights;
    private DayList dayList;
    private List<BookingEntry> results;
    private List<WaitListEntry> result;
    private int numberOfEntries = 0;
    private static final String URL = "jdbc:derby://localhost:1527/FlightSchedulerChengminZoucvz5138";
    private static final String USERNAME = "java";
    private static final String PASSWORD = "java";
    private Connection conn = null;
    private ResultSet rs = null;
    private PreparedStatement pst = null;

    public FlightScheduler() {
        initComponents();
        booking = new Booking();
        flights = new Flights();
        waitList = new WaitList();
        dayList = new DayList();
        bookFlightCombo();
        bookDaysCombo();
        getFlightCombo();
        getFlightByDayCombo();
        waitListGetFlightByDayCombo();
        cancelCustomerCombo();
        cancelDayCombo();
        customerCombo();
        flightDropCombo();
    }

    private void bookFlightCombo() {
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String sql = "SELECT FLIGHTNAME FROM FLIGHT";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                String flightName = rs.getString("FLIGHTNAME");
                bookFlightCombo.addItem(flightName);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        } finally {
            try {
                rs.close();
                pst.close();

            } catch (Exception e) {
            }
        }
    }

    private void bookDaysCombo() {
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String sql = "SELECT HOLIDAY FROM DAY";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                String holiday = rs.getString("HOLIDAY");
                bookDaysCombo.addItem(holiday);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        } finally {
            try {
                rs.close();
                pst.close();

            } catch (Exception e) {
            }
        }
    }

    private void getFlightCombo() {
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String sql = "SELECT FLIGHTNAME FROM FLIGHT";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                String flightName = rs.getString("FLIGHTNAME");
                getFlightCombo.addItem(flightName);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        } finally {
            try {
                rs.close();
                pst.close();

            } catch (Exception e) {
            }
        }
    }

    private void getFlightByDayCombo() {
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String sql = "SELECT HOLIDAY FROM DAY";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                String holiday = rs.getString("HOLIDAY");
                getFlightByDayCombo.addItem(holiday);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        } finally {
            try {
                rs.close();
                pst.close();

            } catch (Exception e) {
            }
        }
    }

    private void waitListGetFlightByDayCombo() {
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String sql = "SELECT HOLIDAY FROM DAY";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                String holiday = rs.getString("HOLIDAY");
                waitListGetFlightByDayCombo.addItem(holiday);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        } finally {
            try {
                rs.close();
                pst.close();

            } catch (Exception e) {
            }
        }
    }

    private void cancelCustomerCombo() {
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String sql = "SELECT CUSTOMER FROM BOOKING";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                String CustomerFromBooking = rs.getString("CUSTOMER");
                cancelCustomerCombo.addItem(CustomerFromBooking);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        } finally {
            try {
                rs.close();
                pst.close();

            } catch (Exception e) {
            }
        }
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String sql1 = "SELECT CUSTOMER FROM WAITLIST";
            pst = conn.prepareStatement(sql1);
            rs = pst.executeQuery();
            while (rs.next()) {
                String CustomerFromWaitList = rs.getString("CUSTOMER");

                cancelCustomerCombo.addItem(CustomerFromWaitList);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        } finally {
            try {
                rs.close();
                pst.close();

            } catch (Exception e) {
            }
        }
    }

    private void cancelDayCombo() {
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String sql = "SELECT HOLIDAY FROM DAY";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                String Day = rs.getString("HOLIDAY");
                cancelDayCombo.addItem(Day);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        } finally {
            try {
                rs.close();
                pst.close();

            } catch (Exception e) {
            }
        }
    }

    private void customerCombo() {
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String sql = "SELECT CUSTOMER FROM BOOKING";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                String CustomerFromBooking = rs.getString("CUSTOMER");
                customerCombo.addItem(CustomerFromBooking);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String sql = "SELECT CUSTOMER FROM WAITLIST";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                String CustomerFromWaitList = rs.getString("CUSTOMER");
                customerCombo.addItem(CustomerFromWaitList);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        } finally {
            try {
                rs.close();
                pst.close();

            } catch (Exception e) {
            }
        }
    }

    private void flightDropCombo() {
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String sql = "SELECT FLIGHTNAME FROM FLIGHT";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                String flightName = rs.getString("FLIGHTNAME");
                dropFlightCombo.addItem(flightName);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        } finally {
            try {
                rs.close();
                pst.close();

            } catch (Exception e) {
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        flightSchedulerLabel = new javax.swing.JLabel();
        FlightScheduler = new javax.swing.JTabbedPane();
        addPane = new javax.swing.JPanel();
        addFlightLabel = new javax.swing.JLabel();
        addSeatLabel = new javax.swing.JLabel();
        addFlightTextField = new javax.swing.JTextField();
        addDayLabel = new javax.swing.JLabel();
        addDayTextField = new javax.swing.JTextField();
        addFlightSeatsSubmitButton = new javax.swing.JButton();
        addDaySubmitButton = new javax.swing.JButton();
        seatSpinner = new javax.swing.JSpinner();
        bookPane = new javax.swing.JPanel();
        customerLabel = new javax.swing.JLabel();
        flightLabel = new javax.swing.JLabel();
        bookSubmitButton = new javax.swing.JButton();
        dateLabel = new javax.swing.JLabel();
        bookFlightCombo = new javax.swing.JComboBox<>();
        bookDaysCombo = new javax.swing.JComboBox<>();
        customerNameTextField = new javax.swing.JTextField();
        statusPane = new javax.swing.JPanel();
        statusDayLabel = new javax.swing.JLabel();
        getFlightByDayButton = new javax.swing.JButton();
        getFlightByDayCombo = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        statusTextArea = new javax.swing.JTextArea();
        statusFlightLabel = new javax.swing.JLabel();
        getFlightCombo = new javax.swing.JComboBox<>();
        waitListPane = new javax.swing.JPanel();
        waitListDayLabel = new javax.swing.JLabel();
        waitListGetFlightByDayCombo = new javax.swing.JComboBox<>();
        waitListGetFlightByDayButton = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        waitListTextArea = new javax.swing.JTextArea();
        customerStatusPane = new javax.swing.JPanel();
        customerNameLabel = new javax.swing.JLabel();
        customerCombo = new javax.swing.JComboBox<>();
        customerStatusSubmitButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        customerStatusTextArea = new javax.swing.JTextArea();
        cancelPane = new javax.swing.JPanel();
        customerCancelLabel = new javax.swing.JLabel();
        cancelCustomerCombo = new javax.swing.JComboBox<>();
        dayCancelLabel = new javax.swing.JLabel();
        cancelDayCombo = new javax.swing.JComboBox<>();
        cancelSubmitButton = new javax.swing.JButton();
        dropFlightPane = new javax.swing.JPanel();
        flightDropLabel = new javax.swing.JLabel();
        dropFlightCombo = new javax.swing.JComboBox<>();
        dropFlightSubmitButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        flightSchedulerLabel.setBackground(new java.awt.Color(255, 255, 255));
        flightSchedulerLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        flightSchedulerLabel.setForeground(new java.awt.Color(255, 0, 51));
        flightSchedulerLabel.setText("Flight Scheduler");

        addFlightLabel.setText("Flight:");

        addSeatLabel.setText("Seat:");

        addDayLabel.setText("Day:");

        addFlightSeatsSubmitButton.setText("Submit");
        addFlightSeatsSubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addFlightSeatsSubmitButtonActionPerformed(evt);
            }
        });

        addDaySubmitButton.setText("Submit");
        addDaySubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDaySubmitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addPaneLayout = new javax.swing.GroupLayout(addPane);
        addPane.setLayout(addPaneLayout);
        addPaneLayout.setHorizontalGroup(
            addPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addPaneLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(addPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(addDayLabel)
                    .addComponent(addFlightLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(addFlightTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                    .addComponent(addDayTextField))
                .addGap(18, 18, 18)
                .addGroup(addPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(addPaneLayout.createSequentialGroup()
                        .addComponent(addSeatLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seatSpinner))
                    .addComponent(addDaySubmitButton))
                .addGap(18, 18, 18)
                .addComponent(addFlightSeatsSubmitButton)
                .addGap(0, 252, Short.MAX_VALUE))
        );
        addPaneLayout.setVerticalGroup(
            addPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addPaneLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(addPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addFlightLabel)
                    .addComponent(addFlightTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addSeatLabel)
                    .addComponent(seatSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addFlightSeatsSubmitButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(addPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addDayLabel)
                    .addComponent(addDayTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addDaySubmitButton))
                .addGap(116, 116, 116))
        );

        FlightScheduler.addTab("Add", addPane);

        customerLabel.setText("Customer:");

        flightLabel.setText("Flight:");

        bookSubmitButton.setText("Submit");
        bookSubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookSubmitButtonActionPerformed(evt);
            }
        });

        dateLabel.setText(" Date:");

        bookFlightCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        bookFlightCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                bookFlightComboItemStateChanged(evt);
            }
        });

        bookDaysCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        bookDaysCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                bookDaysComboItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout bookPaneLayout = new javax.swing.GroupLayout(bookPane);
        bookPane.setLayout(bookPaneLayout);
        bookPaneLayout.setHorizontalGroup(
            bookPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bookPaneLayout.createSequentialGroup()
                .addComponent(customerLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(customerNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(flightLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bookFlightCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bookDaysCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bookSubmitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        bookPaneLayout.setVerticalGroup(
            bookPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bookPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bookPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(customerLabel)
                    .addComponent(flightLabel)
                    .addComponent(bookSubmitButton)
                    .addComponent(dateLabel)
                    .addComponent(bookFlightCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bookDaysCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(customerNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(186, Short.MAX_VALUE))
        );

        FlightScheduler.addTab("Book", bookPane);

        statusDayLabel.setText("Day:");

        getFlightByDayButton.setText("Find");
        getFlightByDayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getFlightByDayButtonActionPerformed(evt);
            }
        });

        getFlightByDayCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        getFlightByDayCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                getFlightByDayComboItemStateChanged(evt);
            }
        });

        statusTextArea.setColumns(20);
        statusTextArea.setRows(5);
        jScrollPane1.setViewportView(statusTextArea);

        statusFlightLabel.setText("Flight:");

        getFlightCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        getFlightCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                getFlightComboItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout statusPaneLayout = new javax.swing.GroupLayout(statusPane);
        statusPane.setLayout(statusPaneLayout);
        statusPaneLayout.setHorizontalGroup(
            statusPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(statusPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(statusPaneLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(statusFlightLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(getFlightCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(statusDayLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(getFlightByDayCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(getFlightByDayButton)))
                .addContainerGap(257, Short.MAX_VALUE))
        );
        statusPaneLayout.setVerticalGroup(
            statusPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, statusPaneLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(statusPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(getFlightByDayButton)
                    .addComponent(getFlightByDayCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(statusDayLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(statusFlightLabel)
                    .addComponent(getFlightCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(140, 140, 140))
        );

        FlightScheduler.addTab("Status", statusPane);

        waitListDayLabel.setText("Day:");

        waitListGetFlightByDayCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        waitListGetFlightByDayCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                waitListGetFlightByDayComboItemStateChanged(evt);
            }
        });

        waitListGetFlightByDayButton.setText("Find");
        waitListGetFlightByDayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                waitListGetFlightByDayButtonActionPerformed(evt);
            }
        });

        waitListTextArea.setColumns(20);
        waitListTextArea.setRows(5);
        jScrollPane4.setViewportView(waitListTextArea);

        javax.swing.GroupLayout waitListPaneLayout = new javax.swing.GroupLayout(waitListPane);
        waitListPane.setLayout(waitListPaneLayout);
        waitListPaneLayout.setHorizontalGroup(
            waitListPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(waitListPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(waitListPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(waitListPaneLayout.createSequentialGroup()
                        .addComponent(waitListDayLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(waitListGetFlightByDayCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(waitListGetFlightByDayButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        waitListPaneLayout.setVerticalGroup(
            waitListPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, waitListPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(waitListPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(waitListDayLabel)
                    .addComponent(waitListGetFlightByDayCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(waitListGetFlightByDayButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        FlightScheduler.addTab("Wait List Status", waitListPane);

        customerNameLabel.setText("Customer:");

        customerCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        customerCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                customerComboItemStateChanged(evt);
            }
        });

        customerStatusSubmitButton.setText("Find");
        customerStatusSubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerStatusSubmitButtonActionPerformed(evt);
            }
        });

        customerStatusTextArea.setColumns(20);
        customerStatusTextArea.setRows(5);
        jScrollPane2.setViewportView(customerStatusTextArea);

        javax.swing.GroupLayout customerStatusPaneLayout = new javax.swing.GroupLayout(customerStatusPane);
        customerStatusPane.setLayout(customerStatusPaneLayout);
        customerStatusPaneLayout.setHorizontalGroup(
            customerStatusPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customerStatusPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(customerStatusPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(customerStatusPaneLayout.createSequentialGroup()
                        .addComponent(customerNameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(customerCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(customerStatusSubmitButton)))
                .addContainerGap(259, Short.MAX_VALUE))
        );
        customerStatusPaneLayout.setVerticalGroup(
            customerStatusPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customerStatusPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(customerStatusPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(customerNameLabel)
                    .addComponent(customerCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(customerStatusSubmitButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                .addContainerGap())
        );

        FlightScheduler.addTab("Customer Status", customerStatusPane);

        customerCancelLabel.setText("Customer:");

        cancelCustomerCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        cancelCustomerCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cancelCustomerComboItemStateChanged(evt);
            }
        });

        dayCancelLabel.setText("Day:");

        cancelDayCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        cancelDayCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cancelDayComboItemStateChanged(evt);
            }
        });

        cancelSubmitButton.setText("Submit");
        cancelSubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelSubmitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout cancelPaneLayout = new javax.swing.GroupLayout(cancelPane);
        cancelPane.setLayout(cancelPaneLayout);
        cancelPaneLayout.setHorizontalGroup(
            cancelPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cancelPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(customerCancelLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancelCustomerCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dayCancelLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancelDayCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancelSubmitButton)
                .addContainerGap(200, Short.MAX_VALUE))
        );
        cancelPaneLayout.setVerticalGroup(
            cancelPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cancelPaneLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(cancelPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(customerCancelLabel)
                    .addComponent(cancelCustomerCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayCancelLabel)
                    .addComponent(cancelDayCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelSubmitButton))
                .addContainerGap(180, Short.MAX_VALUE))
        );

        FlightScheduler.addTab("Cancel", cancelPane);

        flightDropLabel.setText("Flight:");

        dropFlightCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        dropFlightCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                dropFlightComboItemStateChanged(evt);
            }
        });

        dropFlightSubmitButton.setText("Submit");
        dropFlightSubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dropFlightSubmitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dropFlightPaneLayout = new javax.swing.GroupLayout(dropFlightPane);
        dropFlightPane.setLayout(dropFlightPaneLayout);
        dropFlightPaneLayout.setHorizontalGroup(
            dropFlightPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dropFlightPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(flightDropLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dropFlightCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dropFlightSubmitButton)
                .addContainerGap(381, Short.MAX_VALUE))
        );
        dropFlightPaneLayout.setVerticalGroup(
            dropFlightPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dropFlightPaneLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(dropFlightPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(flightDropLabel)
                    .addComponent(dropFlightCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dropFlightSubmitButton))
                .addContainerGap(177, Short.MAX_VALUE))
        );

        FlightScheduler.addTab("Drop", dropFlightPane);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(230, 230, 230)
                .addComponent(flightSchedulerLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(FlightScheduler, javax.swing.GroupLayout.PREFERRED_SIZE, 624, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(flightSchedulerLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FlightScheduler, javax.swing.GroupLayout.PREFERRED_SIZE, 254, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bookFlightComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_bookFlightComboItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            bookFlightCombo.getSelectedItem().toString();
        }
    }//GEN-LAST:event_bookFlightComboItemStateChanged

    private void bookSubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookSubmitButtonActionPerformed

        java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
        int seatsBooked = flights.getFlightSeatsCount(bookFlightCombo.getSelectedItem().toString(),
                bookDaysCombo.getSelectedItem().toString());

        int flightSeats = flights.getFlightSeat(bookFlightCombo.getSelectedItem().toString());
        if (seatsBooked < flightSeats) {
            int result = booking.addBooking(customerNameTextField.getText(),
                    bookFlightCombo.getSelectedItem().toString(), bookDaysCombo.getSelectedItem().toString());

            if (result == 1) {
                JOptionPane.showMessageDialog(this, "Booking Successful",
                        "Message", JOptionPane.PLAIN_MESSAGE);
                customerCombo.addItem(customerNameTextField.getText());
                cancelCustomerCombo.addItem(customerNameTextField.getText());
            } else {
                JOptionPane.showMessageDialog(this, "Booking failed",
                        "Error", JOptionPane.PLAIN_MESSAGE);
            }
        } else {
            int result = waitList.addWaitList(customerNameTextField.getText(),
                    bookFlightCombo.getSelectedItem().toString(),
                    currentTimestamp, bookDaysCombo.getSelectedItem().toString());

            if (result == 1) {
                JOptionPane.showMessageDialog(this, "No seats available, the customer will be place in the WaitList",
                        "Message", JOptionPane.PLAIN_MESSAGE);
                customerCombo.addItem(customerNameTextField.getText());
                cancelCustomerCombo.addItem(customerNameTextField.getText());
            } else {
                JOptionPane.showMessageDialog(this, "Booking failed",
                        "Error", JOptionPane.PLAIN_MESSAGE);
            }
        }

    }//GEN-LAST:event_bookSubmitButtonActionPerformed

    private void bookDaysComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_bookDaysComboItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            bookDaysCombo.getSelectedItem().toString();
        }
    }//GEN-LAST:event_bookDaysComboItemStateChanged

    private void getFlightByDayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getFlightByDayButtonActionPerformed
        statusTextArea.setText(null);
        String rs = "";
        String top = "";
        results = booking.getFlightByDay(getFlightCombo.getSelectedItem().toString(), getFlightByDayCombo.getSelectedItem().toString());
        numberOfEntries = results.size();

        for (int i = 0; i < results.size(); i++) {
            if (numberOfEntries != 0) {

                bookingCurrentEntry = results.get(i);

                rs += "       " + bookingCurrentEntry.getCustomer() + "                  " + bookingCurrentEntry.getFlight()
                        + "              " + bookingCurrentEntry.getDay() + "\n";
                top = "Customer" + "        " + "Flight" + "               " + "Date";
            }

            statusTextArea.setText(top + "\n" + rs);
        }


    }//GEN-LAST:event_getFlightByDayButtonActionPerformed

    private void getFlightByDayComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_getFlightByDayComboItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            getFlightByDayCombo.getSelectedItem().toString();
        }
    }//GEN-LAST:event_getFlightByDayComboItemStateChanged

    private void waitListGetFlightByDayComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_waitListGetFlightByDayComboItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            waitListGetFlightByDayCombo.getSelectedItem().toString();
    }//GEN-LAST:event_waitListGetFlightByDayComboItemStateChanged
    }
    private void waitListGetFlightByDayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_waitListGetFlightByDayButtonActionPerformed
        waitListTextArea.setText(null);
        String rs = "";
        String top = "";
        result = waitList.getWaitListByDay(waitListGetFlightByDayCombo.getSelectedItem().toString());
        numberOfEntries = result.size();

        for (int i = 0; i < result.size(); i++) {
            if (numberOfEntries != 0) {

                waitListCurrentEntry = result.get(i);

                rs += "       " + waitListCurrentEntry.getCustomer() + "                  " + waitListCurrentEntry.getFlight()
                        + "              " + waitListCurrentEntry.getHoliday() + "\n";
                top = "Customer" + "        " + "Flight" + "               " + "Date";
            }

            waitListTextArea.setText(top + "\n" + rs);
        }
    }//GEN-LAST:event_waitListGetFlightByDayButtonActionPerformed

    private void addFlightSeatsSubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFlightSeatsSubmitButtonActionPerformed
        int addResulF = flights.addFlight(addFlightTextField.getText(), (Integer) seatSpinner.getValue());

        if (addResulF == 1) {
            JOptionPane.showMessageDialog(this, "Add flight Successful",
                    "Message", JOptionPane.PLAIN_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(this, "Add flight failed",
                    "Error", JOptionPane.PLAIN_MESSAGE);
        }

        getFlightCombo.addItem(addFlightTextField.getText());
        bookFlightCombo.addItem(addFlightTextField.getText());
        dropFlightCombo.addItem(addFlightTextField.getText());

    }//GEN-LAST:event_addFlightSeatsSubmitButtonActionPerformed

    private void cancelCustomerComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cancelCustomerComboItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            cancelCustomerCombo.getSelectedItem().toString();
        }
    }//GEN-LAST:event_cancelCustomerComboItemStateChanged

    private void cancelDayComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cancelDayComboItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            cancelDayCombo.getSelectedItem().toString();
        }
    }//GEN-LAST:event_cancelDayComboItemStateChanged

    private void cancelSubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelSubmitButtonActionPerformed
        List<BookingEntry> flightResult = booking.getFlightBooking(
                cancelCustomerCombo.getSelectedItem().toString(), cancelDayCombo.getSelectedItem().toString());

        int deleteBookingResult = booking.cancelBooking(cancelCustomerCombo.getSelectedItem().toString(),
                cancelDayCombo.getSelectedItem().toString());

        if (deleteBookingResult == 1) {
            JOptionPane.showMessageDialog(this, "Cancel successful",
                    "Message", JOptionPane.PLAIN_MESSAGE);
            List<WaitListEntry> result = waitList.checkWaitList(flightResult.get(0).getFlight(), flightResult.get(0).getDay());
            System.out.printf("\n%s", result.size());

            if (result.size() != 0) {
                booking.addBooking(result.get(0).getCustomer(), result.get(0).getFlight(),
                        result.get(0).getHoliday());
                waitList.deleteWaitList(result.get(0).getCustomer(), result.get(0).getFlight(),
                        result.get(0).getHoliday());
            } else {
                JOptionPane.showMessageDialog(this, "No customer in waitlist can be book with that flight for that day",
                        "Message ", JOptionPane.PLAIN_MESSAGE);
            }
        } else {
            int deleteWaitListResult = waitList.cancelWaitList(cancelCustomerCombo.getSelectedItem().toString(),
                    cancelDayCombo.getSelectedItem().toString());
            if (deleteWaitListResult == 1) {
                JOptionPane.showMessageDialog(this, "Cancel from waitlist successful",
                        "Message", JOptionPane.PLAIN_MESSAGE);

            } else {
                JOptionPane.showMessageDialog(this, "Cancel failed",
                        "Error", JOptionPane.PLAIN_MESSAGE);
            }
        }
    }//GEN-LAST:event_cancelSubmitButtonActionPerformed

    private void dropFlightComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_dropFlightComboItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            dropFlightCombo.getSelectedItem().toString();
        }
    }//GEN-LAST:event_dropFlightComboItemStateChanged

    private void dropFlightSubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dropFlightSubmitButtonActionPerformed
        List<BookingEntry> customerResult = booking.selectFlightBooking(dropFlightCombo.getSelectedItem().toString());

        int dropResult = flights.dropFlight(dropFlightCombo.getSelectedItem().toString());
        if (dropResult == 1) {
            JOptionPane.showMessageDialog(this, "Drop flight Successful",
                    "Message", JOptionPane.PLAIN_MESSAGE);
            booking.deleteFlightBooking(dropFlightCombo.getSelectedItem().toString());

            for (int i = 0; i < customerResult.size(); i++) {
//                bookingCurrentEntry = customerResult.get(i);
                for (int j = 0; j < flights.getFlightNames().size(); j++) {
                    int seatsBooked = flights.getFlightSeatsCount(flights.getFlightNames().get(j),
                            customerResult.get(i).getDay());

                    int flightSeats = flights.getFlightSeat(flights.getFlightNames().get(j));

                    if (flightSeats - seatsBooked > 0) {
                        int resultAvailable = booking.addBooking(customerResult.get(i).getCustomer(),
                                flights.getFlightNames().get(j), customerResult.get(i).getDay());

                        if (resultAvailable == 1) {
                            JOptionPane.showMessageDialog(this, "Rebooking Successful",
                                    "Message", JOptionPane.PLAIN_MESSAGE);
                            break;
                        } else {
                            JOptionPane.showMessageDialog(this, "Rebooking fail",
                                    "Message", JOptionPane.PLAIN_MESSAGE);
                        }

                    } else {

                    }
                }
            }
            waitList.deleteFlightWaitList(dropFlightCombo.getSelectedItem().toString());
        } else {
            JOptionPane.showMessageDialog(this, "Drop flight failed",
                    "Error", JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_dropFlightSubmitButtonActionPerformed

    private void customerComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_customerComboItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            customerCombo.getSelectedItem().toString();
        }
    }//GEN-LAST:event_customerComboItemStateChanged

    private void customerStatusSubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerStatusSubmitButtonActionPerformed
        customerStatusTextArea.setText(null);
        String rs = "";
        String top = "";
        String resultBooking = "";
        results = booking.getInfoByCustomer(customerCombo.getSelectedItem().toString());
        numberOfEntries = results.size();

        for (int i = 0; i < results.size(); i++) {
            if (numberOfEntries != 0) {

                bookingCurrentEntry = results.get(i);

                rs += "       " + bookingCurrentEntry.getCustomer() + "                  " + bookingCurrentEntry.getFlight()
                        + "              " + bookingCurrentEntry.getDay() + "\n";
                top = "Customer" + "        " + "Flight" + "               " + "Date";
                resultBooking = "Booking List:";
            }
        }

        String rt = "";
        String bot = "";
        String resultWaitList = "";
        result = waitList.getWaitListInfoByCustomer(customerCombo.getSelectedItem().toString());
        numberOfEntries = result.size();

        for (int i = 0; i < result.size(); i++) {
            if (numberOfEntries != 0) {

                waitListCurrentEntry = result.get(i);

                rt += "       " + waitListCurrentEntry.getCustomer() + "                  " + waitListCurrentEntry.getFlight()
                        + "              " + waitListCurrentEntry.getHoliday() + "\n";
                bot = "Customer" + "        " + "Flight" + "               " + "Date";
                resultWaitList = "Wait List:";
            }

        }
        customerStatusTextArea.setText(resultBooking + "\n" + top + "\n" + rs
                + "\n" + resultWaitList + "\n" + bot + "\n" + rt);

    }//GEN-LAST:event_customerStatusSubmitButtonActionPerformed

    private void addDaySubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDaySubmitButtonActionPerformed
        int addResultD = dayList.addDay(addDayTextField.getText());
        if (addResultD == 1) {
            JOptionPane.showMessageDialog(this, "Add day Successful",
                    "Message", JOptionPane.PLAIN_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(this, "Add day failed",
                    "Error", JOptionPane.PLAIN_MESSAGE);
        }

        bookDaysCombo.addItem(addDayTextField.getText());
        getFlightByDayCombo.addItem(addDayTextField.getText());
        waitListGetFlightByDayCombo.addItem(addDayTextField.getText());
        cancelDayCombo.addItem(addDayTextField.getText());
    }//GEN-LAST:event_addDaySubmitButtonActionPerformed

    private void getFlightComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_getFlightComboItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            getFlightCombo.getSelectedItem().toString();
        }
    }//GEN-LAST:event_getFlightComboItemStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws SQLException {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FlightScheduler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FlightScheduler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FlightScheduler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FlightScheduler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FlightScheduler().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane FlightScheduler;
    private javax.swing.JLabel addDayLabel;
    private javax.swing.JButton addDaySubmitButton;
    private javax.swing.JTextField addDayTextField;
    private javax.swing.JLabel addFlightLabel;
    private javax.swing.JButton addFlightSeatsSubmitButton;
    private javax.swing.JTextField addFlightTextField;
    private javax.swing.JPanel addPane;
    private javax.swing.JLabel addSeatLabel;
    private javax.swing.JComboBox<String> bookDaysCombo;
    private javax.swing.JComboBox<String> bookFlightCombo;
    private javax.swing.JPanel bookPane;
    private javax.swing.JButton bookSubmitButton;
    private javax.swing.JComboBox<String> cancelCustomerCombo;
    private javax.swing.JComboBox<String> cancelDayCombo;
    private javax.swing.JPanel cancelPane;
    private javax.swing.JButton cancelSubmitButton;
    private javax.swing.JLabel customerCancelLabel;
    private javax.swing.JComboBox<String> customerCombo;
    private javax.swing.JLabel customerLabel;
    private javax.swing.JLabel customerNameLabel;
    private javax.swing.JTextField customerNameTextField;
    private javax.swing.JPanel customerStatusPane;
    private javax.swing.JButton customerStatusSubmitButton;
    private javax.swing.JTextArea customerStatusTextArea;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JLabel dayCancelLabel;
    private javax.swing.JComboBox<String> dropFlightCombo;
    private javax.swing.JPanel dropFlightPane;
    private javax.swing.JButton dropFlightSubmitButton;
    private javax.swing.JLabel flightDropLabel;
    private javax.swing.JLabel flightLabel;
    private javax.swing.JLabel flightSchedulerLabel;
    private javax.swing.JButton getFlightByDayButton;
    private javax.swing.JComboBox<String> getFlightByDayCombo;
    private javax.swing.JComboBox<String> getFlightCombo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSpinner seatSpinner;
    private javax.swing.JLabel statusDayLabel;
    private javax.swing.JLabel statusFlightLabel;
    private javax.swing.JPanel statusPane;
    private javax.swing.JTextArea statusTextArea;
    private javax.swing.JLabel waitListDayLabel;
    private javax.swing.JButton waitListGetFlightByDayButton;
    private javax.swing.JComboBox<String> waitListGetFlightByDayCombo;
    private javax.swing.JPanel waitListPane;
    private javax.swing.JTextArea waitListTextArea;
    // End of variables declaration//GEN-END:variables
}
