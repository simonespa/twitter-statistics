/**
 * TwitterStatistics.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package twitter.client;

public interface TwitterStatistics extends java.rmi.Remote {
    public java.lang.String listFollowers(java.lang.String username, java.lang.String password) throws java.rmi.RemoteException;
    public java.lang.String listFollowings(java.lang.String username, java.lang.String password) throws java.rmi.RemoteException;
    public java.lang.String getTheMostPopularFollowings(java.lang.String username, java.lang.String password) throws java.rmi.RemoteException;
    public java.lang.String getTheMostPopularFollowers(java.lang.String username, java.lang.String password) throws java.rmi.RemoteException;
    public java.lang.String getTheMostPopularCities(java.lang.String username, java.lang.String password) throws java.rmi.RemoteException;
    public java.lang.String searchContents(java.lang.String username, java.lang.String password, java.lang.String keyword) throws java.rmi.RemoteException;
    public java.lang.String getFollowersAndFollowing(java.lang.String username, java.lang.String password) throws java.rmi.RemoteException;
    public boolean isValidLogin(java.lang.String username, java.lang.String password) throws java.rmi.RemoteException;
}
