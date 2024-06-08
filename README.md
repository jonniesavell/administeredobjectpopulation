# administeredobjectpopulation

this project represents the application that must be run prior to the introduction of any messaging clients; it creates the connection factories and queues (administered objects) and makes them available to applications which depend upon them.

administered objects in JMS are traditionally populated in JNDI (although they can be instantiated in Spring configuration as well). this project uses JNDI backed by an LDAP based directory service. the particular directory service employed is 389 Directory Service (but that does not matter to one wishing to use this solution).

the JNDI provider still uses the javax packaging, which is not desirable. at some point, it is expected that this dependency will be updated to use the newer jakarta package at which time this client will be updated.

this solution performs its duty by means of brute force and that is undesirable; all administered objects are populated into JNDI at once. a more sophisticated solution would selectively unbind and bind only those administered objects required by the application. that approach was not taken at this time precisely because the pain of unbinding and binding everything has not yet been felt.
