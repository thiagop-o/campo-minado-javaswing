package br.com.cod3r.cm.visao;

import java.awt.GridLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import br.com.cod3r.cm.modelo.Tabuleiro;

@SuppressWarnings("serial")
public class PainelTabuleiro extends JPanel {
	public PainelTabuleiro(Tabuleiro tabuleiro) {
		setLayout(new GridLayout(tabuleiro.getLinhas(), tabuleiro.getColunas()));

		tabuleiro.paraCada(c -> add(new BotaoCampo(c)));
		tabuleiro.registrarObservador(e -> {
			
			SwingUtilities.invokeLater(() ->{
			if(e.isGanhou()) {
				JOptionPane.showMessageDialog(this, "Ganhou:) ");
			}else {
				JOptionPane.showMessageDialog(this, "Perdeu:( ");
			}

			Object [] option = {"SIM", "N�O"};
			int opcao = JOptionPane.showOptionDialog(null, "Deseja Continuar???","Aviso",JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,null,option,option[0]);
			if (opcao == 0) {
				tabuleiro.reiniciar();
			}else {
				System.exit(0);
			}
			
			});
		});
	}
}
