package ru.geekbrains.lesson4.task3;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class Program {

/**
 * Разработать контракты и компоненты системы "Покупка онлайн билетов на автобус в час пик".
 *
 * 1.  Предусловия.
 * 2.  Постусловия.
 * 3.  Инвариант.
 * 4.  Определить абстрактные и конкретные классы.
 * 5.  Определить интерфейсы.
 * 6.  Реализовать наследование.
 * 7.  Выявить компоненты.
 * 8.  Разработать Диаграмму компонент использую нотацию UML 2.0. Общая без деталей.
 */
    public static void main(String[] args) {

        Core core = new Core();
        MobileApp mobileApp = new MobileApp(core.getTicketProvider(), core.getCustomerProvider());
        BusStation busStation = new BusStation(core.getTicketProvider());


        if (mobileApp.buyTicket("11000000221")){
            System.out.println("Клиент успешно купил билет.");
            mobileApp.searchTicket(new Date());
            Collection<Ticket> tickets = mobileApp.getTickets();
            if (busStation.checkTicket(tickets.stream().findFirst().get().getQrcode())){
                System.out.println("Клиент успешно прошел в автобус.");
            }
        }
    }

}

class Core{

    private final CustomerProvider customerProvider;
    private final TicketProvider ticketProvider;
    private final PaymentProvider paymentProvider;

    public Core(){
        customerProvider = new CustomerProvider();
        paymentProvider = new PaymentProvider();
        ticketProvider = new TicketProvider(paymentProvider);
    }

    public TicketProvider getTicketProvider() {
        return ticketProvider;
    }

    public CustomerProvider getCustomerProvider() {
        return customerProvider;
    }

}


/**
 * Покупатель
 */
class Customer{

    private static int counter = 400;

    private final int id;

    private Collection<Ticket> tickets = new ArrayList<>();

    {
        id = ++counter;
    }

    public Collection<Ticket> getTickets() {
        return tickets;
    }

    public void setTicket(Ticket ticket) {

        tickets.add(ticket);
    }

    public int getId() {
        return id;
    }

}

/**
 * Билет
 */
class Ticket{
    public Ticket(int id, int customerId, Date date, String qrcode) {
        this.id = id;
        this.customerId = customerId;
        this.date = date;
        this.qrcode = qrcode;
    }

    private int id;

    private int customerId;

    private Date date;

    private String qrcode;

    private boolean enable = true;

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public int getId() {
        return id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public Date getDate() {
        return date;
    }

    public String getQrcode() {
        return qrcode;
    }

    public boolean isEnable() {
        return enable;
    }
}


/**
 * База данных
 */
class Database{

    private static int counter = 1000;
    private Collection<Ticket> tickets = new ArrayList<>();
    private Collection<Customer> customers = new ArrayList<>();

    public Database() {
    }

    public Collection<Ticket> getTickets() {

        return tickets;
    }

    public Customer getCustomer(int clientID) {
        for (Customer customer : customers){
            if (customer.getId() == clientID){
                return customer;
            }
        }
        return null;
    }

    public Collection<Customer> getCustomers(){
        return customers;
    }

    /**
     * Получить актуальную стоимость билета
     * @return
     */
    public double getTicketAmount(){
        return 45;
    }

    /**
     * Получить идентификатор заявки на покупку билета
     * @return
     */
    public int createTicketOrder(int clientId){
        return ++counter;
    }

}

class PaymentProvider{

    public boolean buyTicket(int orderId, String cardNo, double amount){
        //TODO: Обращение к платежному шлюзу, попытка выполнить списание средств ...
        return true;
    }

}

/**
 * Мобильное приложение
 */
class MobileApp{

    private final Customer customer;
    private final TicketProvider ticketProvider;
    private final CustomerProvider customerProvider;

    public Customer getCustomer() {
        return customer;
    }

    public MobileApp(TicketProvider ticketProvider, CustomerProvider customerProvider) {
        this.ticketProvider = ticketProvider;
        this.customerProvider = customerProvider;
        customer = customerProvider.getCustomer(401);

    }

    public Collection<Ticket> getTickets(){
        return customer.getTickets();
    }

    public void searchTicket(Date date){
        ticketProvider.searchTicket(customerProvider.getCustomer(401).getId(), date);
    }

    public boolean buyTicket(String cardNo){
        try{
            customer.setTicket(ticketProvider.buyTicket(customer.getId(), cardNo));
            return true;
        }catch (Exception e){
            System.out.println("Не удалось совершить покупку");
            return false;
        }
    }

}

class TicketProvider{

    private final Database database = new Database();
    private final PaymentProvider paymentProvider;

    public TicketProvider(PaymentProvider paymentProvider){
        this.paymentProvider = paymentProvider;
    }

    public Collection<Ticket> searchTicket(int clientId, Date date){

        Collection<Ticket> tickets = new ArrayList<>();
        for (Ticket ticket: database.getTickets()) {
            if (ticket.getCustomerId() == clientId && ticket.getDate().equals(date))
                tickets.add(ticket);
        }
        return tickets;

    }

    public Ticket buyTicket(int clientId, String cardNo){

        int orderId = database.createTicketOrder(clientId);
        double amount = database.getTicketAmount();
        if (!paymentProvider.buyTicket(orderId,  cardNo, amount)){
            throw new RuntimeException("Не удалось совершить покупку");
        }
        Ticket ticket = new Ticket(orderId, clientId, new Date(), "qr");
        database.getTickets().add(ticket);
        return ticket;
    }

    public boolean checkTicket(String qrcode){
        for (Ticket ticket: database.getTickets()) {
            if (ticket.getQrcode().equals(qrcode)){
                ticket.setEnable(false);
                // Save database ...
                return true;
            }
        }
        return false;
    }


}

class CustomerProvider{

    private Database database = new Database();

    public CustomerProvider() {

    }

    {
        database.getCustomers().add(new Customer());
    }

    public Customer getCustomer(int customerID){

        //Предусловие
        if (customerID < 400){
            throw new RuntimeException("Невалидный ID пользователя!");
        }

        //Выполнение основного кода подпрограммы

        Customer customer = database.getCustomer(customerID);

        //Постусловие
        if (customer == null){
            throw new RuntimeException("Пользователь не найден!");
        }

        return customer;
    }


}

/**
 * Автобусная станция
 */
class BusStation{

    private final TicketProvider ticketProvider;

    public BusStation(TicketProvider ticketProvider){
        this.ticketProvider = ticketProvider;
    }

    public boolean checkTicket(String qrCode){
        return ticketProvider.checkTicket(qrCode);
    }

}


