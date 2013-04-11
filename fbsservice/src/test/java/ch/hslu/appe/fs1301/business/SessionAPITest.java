package ch.hslu.appe.fs1301.business;

import org.junit.Before;
import org.junit.Test;
import org.powermock.api.easymock.PowerMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.isA;
import static org.fest.assertions.Assertions.assertThat;
import ch.hslu.appe.fs1301.business.shared.UserRole;
import ch.hslu.appe.fs1301.business.shared.iSessionAPI;
import ch.hslu.appe.fs1301.data.shared.iPersonRepository;
import ch.hslu.appe.fs1301.data.shared.entity.Person;

/**
 * @author Thomas Bomatter
 * Session API Test
 */
public class SessionAPITest {
	private iSessionAPI fTestee;
	private iPersonRepository fPersonRepositoryMock;
	
	@Before
	public void setUp() {	
		fPersonRepositoryMock = PowerMock.createMock(iPersonRepository.class);
		fTestee = new SessionAPI(fPersonRepositoryMock);		
	}
	
	@Test
	public void isNotAuthenticatedOnStartup() {
		assertThat(fTestee.isAuthenticated()).isFalse();
		assertThat(fTestee.getUserName()).isNullOrEmpty();
		assertThat(fTestee.hasRole(UserRole.CUSTOMER)).isFalse();
	}
	
	@Test
	public void usernameIsSetOnSuccessfulLogin() {
		final String expectedUserName = "UserName";
		
		Person person = getPersonFor(expectedUserName, UserRole.ADMIN, true);
		setupReturnValueOfRepo(person);
		PowerMock.replayAll();
		
		fTestee.authenticate(expectedUserName, "");
		
		assertThat(fTestee.getUserName()).isEqualTo(expectedUserName);
	}
	
	@Test
	public void successfulLoginWhenRoleIsAdminAndIsActive() {
		Person person = getPersonFor("", UserRole.ADMIN, true);
		setupReturnValueOfRepo(person);
		PowerMock.replayAll();

		boolean result = fTestee.authenticate("", "");
		
		assertThat(result).isTrue();
		assertThat(fTestee.isAuthenticated()).isTrue();
	}
	
	@Test
	public void successfulLoginWhenRoleIsSysuserAndIsActive(){
		Person person = getPersonFor("", UserRole.SYSUSER, true);
		setupReturnValueOfRepo(person);
		PowerMock.replayAll();

		boolean result = fTestee.authenticate("", "");
		
		assertThat(result).isTrue();
		assertThat(fTestee.isAuthenticated()).isTrue();
	}
	
	@Test
	public void unsuccessfulLoginWhenRoleIsCustomerAndIsActive(){
		Person person = getPersonFor("", UserRole.CUSTOMER, true);
		setupReturnValueOfRepo(person);
		PowerMock.replayAll();

		boolean result = fTestee.authenticate("", "");
		
		assertThat(result).isFalse();
		assertThat(fTestee.isAuthenticated()).isFalse();
	}
	
	@Test
	public void unsuccessfulLoginWhenRoleIsAdminAndIsInActive(){
		Person person = getPersonFor("", UserRole.ADMIN, false);
		setupReturnValueOfRepo(person);
		PowerMock.replayAll();

		boolean result = fTestee.authenticate("", "");
		
		assertThat(result).isFalse();
		assertThat(fTestee.isAuthenticated()).isFalse();
	}

	@Test
	public void unsuccessfulLoginWhenRoleIsNoneAndIsInActive(){
		Person person = getPersonFor("", UserRole.NONE, false);
		setupReturnValueOfRepo(person);
		PowerMock.replayAll();

		boolean result = fTestee.authenticate("", "");
		
		assertThat(result).isFalse();
		assertThat(fTestee.isAuthenticated()).isFalse();
	}
	
	@Test
	public void unsuccessfulLoginWhenNoUserIsReturned(){
		setupReturnValueOfRepo(null);
		PowerMock.replayAll();

		boolean result = fTestee.authenticate("", "");
		
		assertThat(result).isFalse();
		assertThat(fTestee.isAuthenticated()).isFalse();
	}
	
	private Person getPersonFor(String username, int role, boolean active) {
		Person person = new Person();
		person.setBenutzername(username);
		person.setRolle(role);
		person.setAktiv(active);
		return person;
	}
	
	private void setupReturnValueOfRepo(Person person) {
		expect(fPersonRepositoryMock.getPersonByUsernameAndPassword(isA(String.class), isA(String.class))).
			andReturn(person);
	}
}
