@Test
	public void testPrivateMethod() throws Exception {
		User user=new User();
		user.setFirstName("sasi");
		String s=new String("sasi");
PowerMockito.verifyPrivate(defaultUserService,Mockito.times(2)).invoke("testDemo", user);
defaultUserService=Mockito.mock(DefaultUserService.class);



	public String createUser(User user) {
		return testDemo(user);
		
	}
	private String testDemo(User user) {
		System.out.println("userFirstNAme is"+user.getFirstName());
		return"Hello...."+user.getFirstName();
		
	}
