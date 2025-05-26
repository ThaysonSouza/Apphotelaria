package view.components;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;


public class Sidebar extends VBox {

    public Button btnCliente = new Button();
    public Button btnFuncionarios = new Button();
    public Button btnReserva = new Button();
    public Button btnRelatorio = new Button();
    public Button btnQuarto = new Button();

    public Sidebar() {
                    //Carregamento das imagens
        Image iconFuncionario = new Image(getClass().getResourceAsStream
                ("/view/resources/img/icon-funcionario.png"));
        Image iconCliente = new Image(getClass().getResourceAsStream
                ("/view/resources/img/icon-cliente.png"));
        Image iconQuarto = new Image(getClass().getResourceAsStream
                ("/view/resources/img/icon-quarto.png"));
        Image iconReserva = new Image(getClass().getResourceAsStream
                ("/view/resources/img/icon-reserva.png"));
        Image iconRelatorio = new Image(getClass().getResourceAsStream
                ("/view/resources/img/icon-relatorio.png"));


        //Carregamento das fontes

        Font fontNegrito = Font.loadFont(getClass().getResourceAsStream("/view/resources/fonts/"
                + "RobotoCondensed-ExtraBold.ttf"), 15);

        //Inserir imagem em container para manipilar tamanho/rendimensionamento

        ImageView  viewIconFuncionario = new ImageView(iconFuncionario);
        viewIconFuncionario.setFitWidth(30); //Definição de Largura
        viewIconFuncionario.setFitHeight(30);// Definição de altura

        ImageView viewIconCliente = new ImageView(iconCliente);
        viewIconCliente.setFitWidth(30); //Definição de Largura
        viewIconCliente.setFitHeight(30);// Definição de altura

        ImageView viewIconQuarto = new ImageView(iconQuarto);
        viewIconQuarto.setFitWidth(30);
        viewIconQuarto.setFitHeight(30);

        ImageView  viewIconReserva = new ImageView(iconReserva);
        viewIconReserva.setFitWidth(30);
        viewIconReserva.setFitHeight(30);

        ImageView viewIconRelatorio = new ImageView(iconRelatorio);
        viewIconRelatorio.setFitWidth(30);
        viewIconRelatorio.setFitHeight(30);

        btnCliente.setGraphic(viewIconCliente);
        btnFuncionarios.setGraphic(viewIconFuncionario);
        btnReserva.setGraphic(viewIconReserva);
        btnRelatorio.setGraphic(viewIconRelatorio);
        btnQuarto.setGraphic(viewIconQuarto);

        setSpacing(15);
        setPadding(new Insets(20));

        Label lblMenu = new Label("Grand Hotel");

        lblMenu.setStyle("-fx-text-fill: #a87e08");
        lblMenu.setFont(Font.font(fontNegrito.getFamily(), 25));;


        //Estilizaçao dos botoes
        String styleButton = "-fx-background-color: transparent;" +
                             "-fx-border-color: transparent;" +
                             "-fx-graphic-text-gap: 10px;" +
                             "-fx-alignment: center;" +
                             "-fx-cursor: hand;"; //Setar o cursor de mao para o mouse

        btnCliente.setStyle(styleButton);
        btnRelatorio.setStyle(styleButton);
        btnReserva.setStyle(styleButton);
        btnQuarto.setStyle(styleButton);
        btnFuncionarios.setStyle(styleButton);
        btnQuarto.setStyle(styleButton);

        //ao passar o mouse, trocar o fundo do botao para uma cor que deseja
        btnCliente.setOnMouseEntered(evento ->
                btnCliente.setStyle(styleButton.replace("transparent", "#D6C388FF")));
                btnCliente.setOnMouseExited(evento -> btnCliente.setStyle(styleButton));

        btnFuncionarios.setOnMouseEntered(evento ->
                btnFuncionarios.setStyle(styleButton.replace("transparent", "#D6C388FF")));
                btnFuncionarios.setOnMouseExited(evento -> btnFuncionarios.setStyle(styleButton));

        btnQuarto.setOnMouseEntered(evento ->
                btnQuarto.setStyle(styleButton.replace("transparent", "#D6C388FF")));
                btnQuarto.setOnMouseExited(evento -> btnQuarto.setStyle(styleButton));

        btnReserva.setOnMouseEntered(evento ->
                btnReserva.setStyle(styleButton.replace("transparent", "#D6C388FF")));
                btnReserva.setOnMouseExited(evento -> btnReserva.setStyle(styleButton));

        btnRelatorio.setOnMouseEntered(evento ->
                btnRelatorio.setStyle(styleButton.replace("transparent", "#D6C388FF")));
                btnRelatorio.setOnMouseExited(evento -> btnRelatorio.setStyle(styleButton));

        //espaçamento externo (margem) do componente label ate o botao
        setMargin(lblMenu, new Insets(0, 0, 20,     0 ));

        setStyle("-fx-background-color: #ffffff; -fx-padding: 40");
        getChildren().addAll(lblMenu, btnCliente,btnFuncionarios,btnQuarto,btnReserva, btnRelatorio);

    }

}
