package view;

import javafx.scene.text.Font;
import view.components.Sidebar;
import view.components.PainelBotoes;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CadQuarto extends Application {
    @Override
    public void start(Stage janela) throws Exception {
        PainelBotoes buttons = new PainelBotoes();
        Sidebar menu = new Sidebar();

        //Carregando imagens
        Image imgLogo = new Image(getClass().getResourceAsStream("/img/Logo2.jpeg"));
        Image imgQuarto = new Image(getClass().getResourceAsStream
                ("/view/resources/img/icon-quarto.png"));
        Font fontNegrito = Font.loadFont(getClass().getResourceAsStream("/view/resources/fonts/"
                + "RobotoCondensed-ExtraBold.ttf"), 15);
        Font fontRegular = Font.loadFont(getClass().getResourceAsStream("/view/resources/fonts/"
                + "RobotoCondensed-Regular.ttf"), 14);

        //layout Principal
        BorderPane mainPane = new BorderPane();
        mainPane.setLeft(menu);

        ImageView viewImgQuarto = new ImageView(imgQuarto);
        viewImgQuarto.setFitWidth(20);
        viewImgQuarto.setFitHeight(20);

        //Titulo
        Label lblTitulo = new Label("Reservas de Quartos");
        lblTitulo.setAlignment(Pos.CENTER);
        lblTitulo.setStyle("-fx-text-fill: #a87e08");
        lblTitulo.setFont(Font.font(fontNegrito.getFamily(), 25));
        HBox tituloBox = new HBox(viewImgQuarto, lblTitulo);
        tituloBox.setAlignment(Pos.CENTER);


        Label lblNome = new Label("Nome: ");
        TextField txtNome = new TextField();
        txtNome.setMinWidth(150);
        lblNome.setFont(Font.font(fontRegular.getFamily(), 12));
        txtNome.setFont(Font.font(fontRegular.getFamily(), 12));


        Label lblNumero = new Label("Numero: ");
        TextField txtNumero = new TextField();
        txtNumero.setMinWidth(150);
        lblNumero.setFont(Font.font(fontRegular.getFamily(), 12));
        txtNumero.setFont(Font.font(fontRegular.getFamily(), 12));


        Label lblCamas = new Label("Camas de casal: ");
        lblCamas.setFont(Font.font(fontRegular.getFamily(), 12));
        Spinner<Integer> spnCamas = new Spinner<Integer>();
        spnCamas.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100));

        Label lblSolteiro = new Label("Camas de solteiro: ");
        lblSolteiro.setFont(Font.font(fontRegular.getFamily(), 12));
        Spinner<Integer> spnSolteiro = new Spinner<Integer>();
        spnSolteiro.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100));

        Label lblPreco = new Label("Preço do Quarto: ");
        TextField txtPreco = criarMascaraCampo("R$" + "00.000,00");
        lblPreco.setFont(Font.font(fontRegular.getFamily(), 12));
        txtPreco.setFont(Font.font(fontRegular.getFamily(), 12));


        Label lblDisponivel = new Label("Disponivel: ");
        lblDisponivel.setFont(Font.font(fontRegular.getFamily(), 12));
        ComboBox<String> boxDisponivel = new ComboBox<>();
        boxDisponivel.getItems().addAll("Sim", "Não");
        boxDisponivel.setValue("selecione");


        GridPane fromGrid = new GridPane();
        fromGrid.add(lblNome, 0, 0);
        fromGrid.add(txtNome, 1, 0);

        fromGrid.add(lblNumero, 0, 1);
        fromGrid.add(txtNumero, 1, 1);

        fromGrid.add(lblCamas, 0, 2);
        fromGrid.add(spnCamas, 1, 2);

        fromGrid.add(lblSolteiro, 0, 3);
        fromGrid.add(spnSolteiro, 1, 3);

        fromGrid.add(lblPreco, 0, 4);
        fromGrid.add(txtPreco, 1, 4);

        fromGrid.add(lblDisponivel, 0, 5);
        fromGrid.add(boxDisponivel, 1, 5);
        fromGrid.add(buttons, 1, 6);

        fromGrid.setHgap(10);
        fromGrid.setVgap(10);
        fromGrid.setAlignment(Pos.CENTER);


        VBox layout = new VBox(10, tituloBox, fromGrid);
        layout.setAlignment(Pos.CENTER);
        mainPane.setCenter(layout);
        Scene scene = new Scene(mainPane, 800, 500);

        janela.setTitle("Grand Hotel");
        janela.getIcons().add(imgLogo);
        janela.setScene(scene);
        janela.show();
        janela.setResizable(false);
    }

    private TextField criarMascaraCampo(String mascara) {
        TextField txtMascara = new TextField();
        txtMascara.textProperty().addListener((observable, oldValue, newValue) -> {
            String value = newValue.replaceAll("[^0-9]", "");
            StringBuilder formatacaoCampo = new StringBuilder();
            int index = 0;
            for (char caracter : mascara.toCharArray()) {
                if (caracter == '#') {
                    if (index < value.length()) {
                        formatacaoCampo.append(value.charAt(index));
                        index++;
                    } else {
                        break;
                    }
                } else {
                    formatacaoCampo.append(caracter);
                }
            }
            txtMascara.setText(formatacaoCampo.toString());
        });
        return txtMascara;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
