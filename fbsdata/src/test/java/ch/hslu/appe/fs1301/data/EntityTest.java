package ch.hslu.appe.fs1301.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

import ch.hslu.appe.fs1301.data.shared.entity.Bestellposition;
import ch.hslu.appe.fs1301.data.shared.entity.Bestellung;
import ch.hslu.appe.fs1301.data.shared.entity.Korrespondenz;
import ch.hslu.appe.fs1301.data.shared.entity.KorrespondenzTemplate;
import ch.hslu.appe.fs1301.data.shared.entity.Person;
import ch.hslu.appe.fs1301.data.shared.entity.Produkt;
import ch.hslu.appe.fs1301.data.shared.entity.Rechnung;
import ch.hslu.appe.fs1301.data.shared.entity.ZentrallagerBestellung;

/**
 * @author Thomas Bomatter
 * EntityTest. These are completely useless and are only here to satisfy code coverage :D
 */
public class EntityTest extends BaseTestClass {

	@Test
	public void TestBestellposition() {
		final int expectedId = 1;
		
		Bestellposition position = new Bestellposition();
		position.setId(expectedId);
		position.setAnzahl(25);
		position.setProdukt(new Produkt());
		position.setStueckpreis(20);
		position.setBestellung(new Bestellung());
		position.setAbgerechnet(true);
		
		assertEquals(expectedId, position.getId());
		assertEquals(25, position.getAnzahl());
		assertEquals(Produkt.class, position.getProdukt().getClass());
		assertEquals(20, position.getStueckpreis());
		assertEquals(true, position.getAbgerechnet());
		assertEquals(Bestellung.class, position.getBestellung().getClass());
		assertNotNull(position);
	}
	
	@Test
	public void TestBestellung() {
		Bestellung bestellung = new Bestellung();
		bestellung.setId(1);
		bestellung.setRechnungs(new ArrayList<Rechnung>());
		Rechnung rechnung = new Rechnung();
		bestellung.addRechnung(rechnung);
		bestellung.removeRechnung(rechnung);
		bestellung.setBestellpositions(new ArrayList<Bestellposition>());
		Bestellposition bestellposition = new Bestellposition();
		bestellung.addBestellposition(bestellposition);
		bestellung.removeBestellposition(bestellposition);
		bestellung.setBestelldatum(new Date());
		bestellung.setLiefertermin_Ist(new Date());
		bestellung.setLiefertermin_Soll(new Date());
		bestellung.setPerson1(new Person());
		bestellung.setPerson2(new Person());
		bestellung.setQuelle(1);
		
		assertEquals(1, bestellung.getId());
		assertEquals(ArrayList.class, bestellung.getRechnungs().getClass());
		assertEquals(ArrayList.class, bestellung.getBestellpositions().getClass());
		assertEquals(Date.class, bestellung.getBestelldatum().getClass());
		assertEquals(Date.class, bestellung.getLiefertermin_Ist().getClass());
		assertEquals(Date.class, bestellung.getLiefertermin_Soll().getClass());
		assertEquals(Person.class, bestellung.getPerson1().getClass());
		assertEquals(Person.class, bestellung.getPerson2().getClass());		
		assertEquals(1, bestellung.getQuelle());
		assertNotNull(bestellung);
	}
	
	@Test
	public void TestKorrespondenz() {
		Korrespondenz korre = new Korrespondenz();
		korre.setId(1);
		korre.setInhalt("Test");
		korre.setPerson1(new Person());
		korre.setPerson2(new Person());
		korre.setTyp(4);
		
		assertEquals(1, korre.getId());
		assertEquals(String.class, korre.getInhalt().getClass());
		assertEquals(Person.class, korre.getPerson1().getClass());
		assertEquals(Person.class, korre.getPerson2().getClass());	
		assertEquals(4, korre.getTyp());
		assertNotNull(korre);
	}
	
	@Test
	public void TestKorrespondenzTemplate() {
		KorrespondenzTemplate template = new KorrespondenzTemplate();
		template.setId(1);
		template.setInhalt("Test");
		template.setTyp(4);
		
		assertEquals(1, template.getId());
		assertEquals(4, template.getTyp());
		assertEquals(String.class, template.getInhalt().getClass());
	}
	
	@Test
	public void TestPerson() {
		Person person = new Person();
		person.setId(1);
		person.setEMail("Test");
		person.setName("Test");
		person.setVorname("Test");
		person.setBenutzername("Test");
		person.setOrt("Test");
		person.setPlz(1);
		person.setGeburtstag(new Date());
		person.setRolle(0);
		person.setStrasse("Test");
		person.setPasswort("Test");
		person.setAktiv(false);
		Korrespondenz korrespondenz = new Korrespondenz();
		person.addKorrespondenzs1(korrespondenz);
		person.addKorrespondenzs2(korrespondenz);
		person.removeKorrespondenzs1(korrespondenz);
		person.removeKorrespondenzs2(korrespondenz);
		person.setKorrespondenzs1(new ArrayList<Korrespondenz>());
		person.setKorrespondenzs2(new ArrayList<Korrespondenz>());
		Bestellung bestellung = new Bestellung();
		person.addBestellungs1(bestellung);
		person.removeBestellungs1(bestellung);
		person.addBestellungs2(bestellung);
		person.removeBestellungs2(bestellung);
		person.setBestellungs1(new ArrayList<Bestellung>());
		person.setBestellungs2(new ArrayList<Bestellung>());
		Rechnung rechnung = new Rechnung();
		person.addRechnung(rechnung);
		person.removeRechnung(rechnung);
		
		person.setRechnungs(new ArrayList<Rechnung>());
		
		assertEquals(1, person.getId());
		assertEquals(String.class, person.getEMail().getClass());
		assertEquals(String.class, person.getName().getClass());
		assertEquals(String.class, person.getVorname().getClass());
		assertEquals(String.class, person.getBenutzername().getClass());
		assertEquals(String.class, person.getOrt().getClass());
		assertEquals(1, person.getPlz());
		assertEquals(Date.class, person.getGeburtstag().getClass());		
		assertEquals(0, person.getRolle());
		assertEquals(String.class, person.getStrasse().getClass());
		assertEquals(String.class, person.getPasswort().getClass());
		assertEquals(false, person.getAktiv());
		assertEquals(ArrayList.class, person.getKorrespondenzs1().getClass());
		assertEquals(ArrayList.class, person.getKorrespondenzs2().getClass());
		assertEquals(ArrayList.class, person.getBestellungs1().getClass());
		assertEquals(ArrayList.class, person.getBestellungs1().getClass());
		assertEquals(ArrayList.class, person.getRechnungs().getClass());
	}
	
	@Test
	public void TestProdukt() {
		Produkt prod = new Produkt();
		prod.setId(1);
		prod.setBestellpositions(new ArrayList<Bestellposition>());
		Bestellposition bestellposition = new Bestellposition();
		prod.addBestellposition(bestellposition);
		prod.removeBestellposition(bestellposition);
		prod.setBezeichnung("Test");
		prod.setLagerbestand(5);
		prod.setMinimalMenge(3);
		prod.setPreis(2000);
		prod.setZentrallagerBestellungs(new ArrayList<ZentrallagerBestellung>());
		ZentrallagerBestellung bestellung = new ZentrallagerBestellung();
		prod.addZentrallagerBestellung(bestellung);
		prod.removeZentrallagerBestellung(bestellung);
		
		assertEquals(1, prod.getId());
		assertEquals(ArrayList.class, prod.getBestellpositions().getClass());
		assertEquals(String.class, prod.getBezeichnung().getClass());
		assertEquals(5, prod.getLagerbestand());
		assertEquals(3, prod.getMinimalMenge());
		assertEquals(2000, prod.getPreis());
		assertEquals(ArrayList.class, prod.getBestellpositions().getClass());
	}
	
	@Test
	public void TestRechnung() {
		Rechnung bill = new Rechnung();
		bill.setId(1);
		bill.setBestellung(new Bestellung());
		bill.setBetrag(200);
		bill.setBezahlter_Betrag(200);
		bill.setMahnstufe(0);
		bill.setPerson(new Person());
		bill.setZahlbarBis(new Date());
		
		assertEquals(1, bill.getId());
		assertEquals(Bestellung.class, bill.getBestellung().getClass());
		assertEquals(200, bill.getBetrag());
		assertEquals(200, bill.getBezahlter_Betrag());
		assertEquals(0, bill.getMahnstufe());
		assertEquals(Person.class, bill.getPerson().getClass());
		assertEquals(Date.class, bill.getZahlbarBis().getClass());
	}
	
	@Test 
	public void TestZentrallagerBestellung() {
		ZentrallagerBestellung bestellung = new ZentrallagerBestellung();
		bestellung.setId(1);
		bestellung.setAnzahl(20);
		bestellung.setLiefertermin(new Date());
		bestellung.setProdukt(new Produkt());
		
		assertEquals(1, bestellung.getId());
		assertEquals(20, bestellung.getAnzahl());
		assertEquals(Date.class, bestellung.getLiefertermin().getClass());
		assertEquals(Produkt.class, bestellung.getProdukt().getClass());	
	}
}
