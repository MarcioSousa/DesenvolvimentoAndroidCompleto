package com.cursoandroid.trechosbiblicos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    //EU ESTAREI CONTIGO.
    //Ex 3, 12a
    private TextView textPalavra, textTrecho, textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textPalavra = findViewById(R.id.textPalavra);
        textTrecho = findViewById(R.id.textTrecho);
        textView3 = findViewById(R.id.textView3);

        int numerocont = 5;
        int diferenca = 0;
        int resto;

        //DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        //Date data = new Date(2022,9,21);
        //Date data1 = new Date(2022,10,20);
        //diferenca = data1.getDate() - data.getDate();
        //diferenca = dateFormat.format(data);

        //Esse trecho faz a diferença entre duas datas
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date primeiraDt = sdf.parse("01/10/2022");
            //Date segundaDt = sdf.parse("20/10/2022");
            Date segundaDt = new Date();

            long diffEmMil = Math.abs(segundaDt.getTime() - primeiraDt.getTime());

            long diff = TimeUnit.DAYS.convert(diffEmMil, TimeUnit.MILLISECONDS);

            diferenca = (int) (diffEmMil / (1000 * 60 * 60 * 24));

        } catch (ParseException e) {
            e.printStackTrace();
        }

        textPalavra.setText(palavra()[diferenca % palavra().length]);
        textTrecho.setText(trecho()[diferenca % palavra().length]);
        textView3.setText(String.valueOf(diferenca % palavra().length));

    }

    private String[] palavra(){
        String[] frases = {
                "Eu estarei contigo.",
                "Derramarei sobre vós águas puras, que vos purificarão de todas as vossas imundicies e de todas as vossas abominiações. " +
                        "Eu vos darei um coração novo e em vós porei um espírito novo; tirarei do vosso peito o coração de pedra e vos darei um coração de carne. " +
                        "Dentro de vós colocarei meu espírito, fazendo com que obedeçais às minhas leis e sigais e observeis os meus preceitos. " +
                        "Habitarei a terra de que fiz presente a vossos pais; sereis meu povo, e serei vosso Deus.",
                "'Velai sobre vós mesmos, para que os vossos corações não se tornem pesados com o excesso do comer, com a embriaguez e com as preocupações da vida; para que aquele dia não vos apanhe de improviso. " +
                        "Como um laço cairá sobre aqueles que habitam a face de toda a terra. " +
                        "Vigiai, pois, em todo o tempo e orai, a fim de que vos torneis dignos de escapar a todos esses males que hão de acontecer, e de vos apresentar de pé diante do Filho do Homem.'",
                "Vinde a mim, vós todos que estais aflitos sob o fardo, e eu vos aliviarei. " +
                        "Tomai meu jugo sobre vós e recebei minha doutrina, porque eu sou manso e humilde de coração e acharei o repouso para vossas almas. " +
                        "Porque meu jugo é suave e meu peso é leve.",
                "Não te deixarei nem desamparei (Dt 31, 6).",
                "Adquirir a sabedoria vale mais que o ouro; antes adquirir a inteligência que a prata. " +
                        "O caminho dos corretos consiste em evitar o mal; o que vigia seu procedimento conserva sua vida. " +
                        "A soberba precede à ruína; e o orgulho, à queda. " +
                        "Mais vale ser honesto com os humildes que repartir o despojo com os soberbos. " +
                        "Quem ouve a palavra com atenção encontra a felicidade; ditoso quem confia no Senhor. " +
                        "Inteligente é o que possui o coração sábio; a doçura da linguagem aumenta o saber. " +
                        "A inteligência é fonte de vida para quem a possui; o castigo dos insensatos é a loucura. " +
                        "O coração do sábio torna sua boca instruída, e acrescenta-lhes aos lábios o saber. " +
                        "As palavras agradáveis são como um favo de mel; doçura para a alma e saúde para os ossos. " +
                        "Há caminhos que parecem retos ao homem, contudo, o seu terno é a morte. " +
                        "A fome do trabalhador trabalha por ele, porque sua boca o constrange a isso. " +
                        "O perverso cava o mal, há em seus lábios como que fogo devorador. " +
                        "O perverso excita questões, o detrator separa os amigos." +
                        "O violento seduz seu próximo e o arrasta pelo mau caminho. " +
                        "Quem fecha os olhos e planeja intriga, ao morder os lábios, já praticou o mal. " +
                        "Os cabelos brancos são uma coroa de glória a quem se encontra no caminho da justiça. " +
                        "Mais vale a paciência que o heroísmo, mais vale quem domina o coração do que aquele que conquista uma cidade. " +
                        "As sortes lançam-se nas dobras do manto, mas do Senhor depende toda a decisão.",
                "Realmente, está escrito: Por amor de ti somos entregues à morte o dia inteiro; somos tratados como gado destinado ao matadouro (Sl 43, 23). " +
                        "Mas, em todas essas coisas, somos mais que vencedores pela virtude daquele que nos amou. " +
                        "Pois estou persuadido de que nem a morte, nem a vida, nem os anjos, nem os principados, nem o presente, nem o futuro, nem as potestades, " +
                        "nem as alturas, nem os abismos, nem outra qualquer criatura nos poderá apartar do amor que Deus nos testemunha em Cristo Jesus, nosso Senhor."
        };
        return frases;
    }

    private String[] trecho(){
        String[] trechos = {
                "Ex 3, 12a",
                "Ez 36, 25 - 30",
                "Lc 21, 34 - 36",
                "Mt 11, 38 - 30",
                "Hb 13, 5b",
                "Pr 16, 16 - 33",
                "Rm 8, 36 - 39"
        };
        return trechos;
    }

}
