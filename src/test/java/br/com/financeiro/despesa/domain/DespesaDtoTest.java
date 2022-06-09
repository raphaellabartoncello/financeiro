package br.com.financeiro.despesa.domain;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class DespesaDtoTest {

    @Test
    void getSetidDespesa() {
        DespesaDto p = new DespesaDto();
//        UUID testValue = UUID.randomUUID();
        Random random = new Random();
        Long testValue = random.nextLong();
        p.setIdDespesa(testValue);
        assertThat(p.getIdDespesa()).isEqualTo(testValue);
    }

    @Test
    void getSetNomeDespesa() {
        DespesaDto p = new DespesaDto();
        String testValue = "Teste DTO";
        p.setNomeDespesa(testValue);
        assertThat(p.getNomeDespesa()).isEqualTo(testValue);
    }

    @Test
    void getSetValor() {
        DespesaDto p = new DespesaDto();
        float testValue = 50;
        p.setValor(testValue);
        assertThat(p.getValor()).isEqualTo(testValue);
    }

    @Test
    void testEqualsOK() {
//        DespesaDto p = new DespesaDto(UUID.randomUUID(),"Ifood","VCH123456",50);
        Random random = new Random();
        DespesaDto p = new DespesaDto(random.nextLong(),"Ifood",50);
        assertThat(p.equals(p)).isTrue();
    }

    @Test
    void testEqualsNOK() {
//        DespesaDto p = new DespesaDto(UUID.randomUUID(),"Rappi",30);
        Random random = new Random();
        DespesaDto p = new DespesaDto(random.nextLong(),"Rappi",30);
        assertThat(p.equals(null)).isFalse();
    }

    @Test
    void testEqualsNOK_CLASSE() {
        DespesaDto p = new DespesaDto();
        assertThat(p.equals(new Despesa())).isFalse();
    }

    @Test
    void testEqualsNOK_ID() {
//        DespesaDto p1 = new DespesaDto(UUID.randomUUID(),"Rappi",30);
//        DespesaDto p2 = new DespesaDto(UUID.randomUUID(),"Rappi",30);
        Random random = new Random();
        DespesaDto p1 = new DespesaDto(random.nextLong(),"Rappi",30);
        DespesaDto p2 = new DespesaDto(random.nextLong(),"Rappi",30);
        assertThat(p1.equals(p2)).isFalse();
    }

    @Test
    void testEqualsNOK_nomeParceiro() {
        Random random = new Random();
        DespesaDto p1 = new DespesaDto(random.nextLong(),"Rappi",30);
        DespesaDto p2 = new DespesaDto(random.nextLong(),"Rappi",30);
        assertThat(p1.equals(p2)).isFalse();
    }

    @Test
    void testEqualsNOK_codigoProduto() {
        Random random = new Random();
        DespesaDto p1 = new DespesaDto(random.nextLong(),"Rappi",30);
        DespesaDto p2 = new DespesaDto(random.nextLong(),"Rappi",30);
        assertThat(p1.equals(p2)).isFalse();
    }

    @Test
    void testEqualsNOK_valorProduto() {
        Random random = new Random();
        DespesaDto p1 = new DespesaDto(random.nextLong(),"Rappi",30);
        DespesaDto p2 = new DespesaDto(random.nextLong(),"Rappi",30);
        assertThat(p1.equals(p2)).isFalse();
    }

    @Test
    void testHash(){
//        DespesaDto p = new DespesaDto(UUID.randomUUID(),"Ifood","VCH123456",50);
        Random random = new Random();
        DespesaDto p = new DespesaDto(random.nextLong(),"Ifood",50);
        int h = p.hashCode();
        assertThat(p.hashCode()).isEqualTo(h);
    }

    @Test
    void testString(){
//        DespesaDto p = new DespesaDto(UUID.randomUUID(),"Ifood","VCH123456",50);
        Random random = new Random();
        DespesaDto p = new DespesaDto(random.nextLong(),"Ifood",50);
        String s = p.toString();
        assertThat(p).hasToString(s);
    }
}
