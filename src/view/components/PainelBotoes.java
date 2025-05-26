package view.components;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

public class PainelBotoes extends HBox {
    public Button btnCadastrar = new Button("Cadastrar");
    public Button btnAtualizar = new Button("Atualizar");
    public Button btnExcluir = new Button("Excluir");


    public PainelBotoes() {

        //carregar imagem
        Image iconBtnCadastrar = new Image(getClass().getResourceAsStream
                ("/view/resources/img/adicionar.png"));
        Image iconBtnAtualizar = new Image(getClass().getResourceAsStream
                ("/view/resources/img/atualizar.png"));
        Image iconBtnExcluir = new Image(getClass().getResourceAsStream
                ("/view/resources/img/delet.png"));

        //Fontes
        Font fontRegular = Font.loadFont(getClass().getResourceAsStream("/view/resources/fonts/"
                + "RobotoCondensed-Regular.ttf"), 14);

        //Inserir imagem em container para manipilar tamanho/rendimensionamento
        ImageView icon1 = new ImageView(iconBtnCadastrar);
        icon1.setFitWidth(20); //Definição de Largura
        icon1.setFitHeight(20);// Definição de altura
        icon1.setOpacity(1); //Definição de opacidade: 0.0 - invisível / 1.0 - opaco
        // Caso queira a opacidade maxima nao é necessario colocar

        ImageView icon2 = new ImageView(iconBtnAtualizar);
        icon2.setFitWidth(20); //Definição de Largura
        icon2.setFitHeight(20);// Definição de altura

        ImageView icon3 = new ImageView(iconBtnExcluir);
        icon3.setFitWidth(20);
        icon3.setFitHeight(20);

        //Faz o icon aparecer no botao
        btnCadastrar.setGraphic(icon1);
        btnAtualizar.setGraphic(icon2);
        btnExcluir.setGraphic(icon3);

        //Estilizaçao
        btnCadastrar.setStyle("-fx-background-color: #b3df9e "); //Cor do fundo do botao
        btnAtualizar.setStyle("-fx-background-color: #b3df9e ");
        btnExcluir.setStyle("-fx-background-color: #fa7574 ");


        setSpacing(15);//Espaçamento

        //set da fonte                                          Tamanho da escrita
        btnCadastrar.setFont(Font.font(fontRegular.getFamily(), 12));
        btnAtualizar.setFont(Font.font(fontRegular.getFamily(), 12));
        btnExcluir.setFont(Font.font(fontRegular.getFamily(), 12));

        String styleButton = "-fx-background-color: transparent;" +
                "-fx-border-color: transparent;" +
                "-fx-graphic-text-gap: 10px;" +
                "-fx-alignment: center;" +
                "-fx-cursor: hand;"; //Setar o cursor de mao para o mouse

        btnCadastrar.setStyle(styleButton);
        btnAtualizar.setStyle(styleButton);
        btnExcluir.setStyle(styleButton);

        btnCadastrar.setOnMouseEntered(evento ->
                btnCadastrar.setStyle(styleButton.replace("transparent", "#D6C388FF")));
        btnCadastrar.setOnMouseExited(evento -> btnCadastrar.setStyle(styleButton));

        btnAtualizar.setOnMouseEntered(evento ->
                btnAtualizar.setStyle(styleButton.replace("transparent", "#D6C388FF")));
        btnAtualizar.setOnMouseExited(evento -> btnAtualizar.setStyle(styleButton));

        btnExcluir.setOnMouseEntered(evento ->
                btnExcluir.setStyle(styleButton.replace("transparent", "#D6C388FF")));
        btnExcluir.setOnMouseExited(evento -> btnExcluir.setStyle(styleButton));



        getChildren().addAll(btnCadastrar, btnAtualizar, btnExcluir);


    }
}
