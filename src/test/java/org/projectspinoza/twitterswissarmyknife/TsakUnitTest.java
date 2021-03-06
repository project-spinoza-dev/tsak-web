package org.projectspinoza.twitterswissarmyknife;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.projectspinoza.twitterswissarmyknife.command.BaseCommand;
import org.projectspinoza.twitterswissarmyknife.command.CommandDumpAccountSettings;
import org.projectspinoza.twitterswissarmyknife.command.CommandDumpAvailableTrends;
import org.projectspinoza.twitterswissarmyknife.command.CommandDumpBlockList;
import org.projectspinoza.twitterswissarmyknife.command.CommandDumpFavourites;
import org.projectspinoza.twitterswissarmyknife.command.CommandDumpFollowerIDs;
import org.projectspinoza.twitterswissarmyknife.command.CommandDumpFollowersList;
import org.projectspinoza.twitterswissarmyknife.command.CommandDumpFriendIDs;
import org.projectspinoza.twitterswissarmyknife.command.CommandDumpFriendsList;
import org.projectspinoza.twitterswissarmyknife.command.CommandDumpGeoDetails;
import org.projectspinoza.twitterswissarmyknife.command.CommandDumpHomeTimeLine;
import org.projectspinoza.twitterswissarmyknife.command.CommandDumpIncomingFriendships;
import org.projectspinoza.twitterswissarmyknife.command.CommandDumpMemberSuggestions;
import org.projectspinoza.twitterswissarmyknife.command.CommandDumpMentionsTimeLine;
import org.projectspinoza.twitterswissarmyknife.command.CommandDumpMutesIDs;
import org.projectspinoza.twitterswissarmyknife.command.CommandDumpMutesList;
import org.projectspinoza.twitterswissarmyknife.command.CommandDumpOutgoingFriendships;
import org.projectspinoza.twitterswissarmyknife.command.CommandDumpOwnRetweets;
import org.projectspinoza.twitterswissarmyknife.command.CommandDumpPlaceTrends;
import org.projectspinoza.twitterswissarmyknife.command.CommandDumpRetweeters;
import org.projectspinoza.twitterswissarmyknife.command.CommandDumpSavedSearches;
import org.projectspinoza.twitterswissarmyknife.command.CommandDumpSimilarPlaces;
import org.projectspinoza.twitterswissarmyknife.command.CommandDumpStatus;
import org.projectspinoza.twitterswissarmyknife.command.CommandDumpSuggestedUserCats;
import org.projectspinoza.twitterswissarmyknife.command.CommandDumpUserListMembers;
import org.projectspinoza.twitterswissarmyknife.command.CommandDumpUserListMemberships;
import org.projectspinoza.twitterswissarmyknife.command.CommandDumpUserListSubscribers;
import org.projectspinoza.twitterswissarmyknife.command.CommandDumpUserListSubscriptions;
import org.projectspinoza.twitterswissarmyknife.command.CommandDumpUserSuggestions;
import org.projectspinoza.twitterswissarmyknife.command.CommandSearchUsers;
import org.projectspinoza.twitterswissarmyknife.command.CommandShowFriendShip;
import org.projectspinoza.twitterswissarmyknife.util.TsakResponse;

import twitter4j.AccountSettings;
import twitter4j.Category;
import twitter4j.GeoLocation;
import twitter4j.GeoQuery;
import twitter4j.IDs;
import twitter4j.Location;
import twitter4j.PagableResponseList;
import twitter4j.Paging;
import twitter4j.Place;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.RateLimitStatus;
import twitter4j.Relationship;
import twitter4j.ResponseList;
import twitter4j.SavedSearch;
import twitter4j.Status;
import twitter4j.Trends;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.User;
import twitter4j.UserList;

@PowerMockIgnore("javax.management.*")
@RunWith(PowerMockRunner.class)
@PrepareForTest({ Paging.class, Query.class, QueryResult.class, GeoLocation.class, GeoQuery.class, CommandDumpSimilarPlaces.class, BaseCommand.class })
public class TsakUnitTest {

    long testUserId = 101010111;
    long testSlugId = 101010111;
    long testListId = 101010111;
    long testStatusId = 1;

    String testUserName = "bit-whacker";
    String testOutput = "testOutput.txt";
    String testPlaceId = "5a110d312052166f";
    String testSlug = "sports";
    String testPlaceName = "New York";
    String testKeywords = "Cofee";
    String testSource = "test source";
    String testTarget = "test target";

    Double testLongitude = 74.0059;
    Double testLatitude = 40.7127;

    int testWoeId = 1;
    int testLimit = 1;

    @Mock
    Twitter twitter;
    IDs ids;
    RateLimitStatus rateLimitStatus;
    AccountSettings settings;
    ResponseList<Location> locationsList;
    PagableResponseList<User> blockList;
    Paging page;
    QueryResult queryResult;
    Query query;
    GeoLocation geoLocation;
    ResponseList<Status> statusList;
    List<PagableResponseList<User>> userList;
    PagableResponseList<User> userPagableList;
    Place place;
    ResponseList<Place> placeResponseList;
    ResponseList<User> userRList;
    Trends trends;
    ResponseList<SavedSearch> savedSearchResponseList;
    Status status;
    ResponseList<Category> categoryResponseList;
    PagableResponseList<UserList> userPRLists;
    Relationship relationship;

    @SuppressWarnings("unchecked")
    @Before
    public void setup() throws Exception {
        twitter = Mockito.mock(Twitter.class);
        settings = Mockito.mock(AccountSettings.class);
        ids = Mockito.mock(IDs.class);
        rateLimitStatus = Mockito.mock(RateLimitStatus.class);
        locationsList = Mockito.mock(ResponseList.class);
        statusList = Mockito.mock(ResponseList.class);
        blockList = Mockito.mock(PagableResponseList.class);
        page = Mockito.mock(Paging.class);
        queryResult = Mockito.mock(QueryResult.class);
        geoLocation = Mockito.mock(GeoLocation.class);
        query = Mockito.mock(Query.class);
        userList = Mockito.mock(List.class);
        userRList = Mockito.mock(ResponseList.class);
        userPagableList = Mockito.mock(PagableResponseList.class);
        userPRLists = Mockito.mock(PagableResponseList.class);
        place = Mockito.mock(Place.class);
        page = Mockito.mock(Paging.class);
        trends = Mockito.mock(Trends.class);
        status = Mockito.mock(Status.class);
        savedSearchResponseList = Mockito.mock(ResponseList.class);
        categoryResponseList = Mockito.mock(ResponseList.class);
        relationship = Mockito.mock(Relationship.class);
        PowerMockito.whenNew(GeoLocation.class).withArguments(testLatitude, testLongitude).thenReturn(geoLocation);
    }

    @Test
    public void testCase_1() throws TwitterException {

        CommandDumpFollowerIDs testCommand = new CommandDumpFollowerIDs();
        testCommand.setScreenName(testUserName);
        testCommand.setOutputFile(testOutput);
        testCommand.setLimit(testLimit);

        TsakResponse expected = new TsakResponse(0, new ArrayList<IDs>(Arrays.asList(ids)));
        expected.setCommandDetails(testCommand.toString());

        Mockito.when(twitter.getFollowersIDs(testUserName, -1)).thenReturn(ids);
        Mockito.when(ids.getNextCursor()).thenReturn(0L);
        Mockito.when(ids.getRateLimitStatus()).thenReturn(rateLimitStatus);
        Mockito.when(rateLimitStatus.getRemaining()).thenReturn(0);

        TsakResponse result = testCommand.execute(twitter);

        assertEquals(expected.getRemApiLimits(), result.getRemApiLimits());
        assertEquals(expected.getResponseData(), result.getResponseData());
        assertEquals(expected.getCommandDetails(), result.getCommandDetails());

    }

    @Test
    public void testCase_2() throws TwitterException {

        CommandDumpAccountSettings testCommand = new CommandDumpAccountSettings();
        testCommand.setHelp(true);
        testCommand.setOutputFile(testOutput);

        TsakResponse expected = new TsakResponse(0, settings);
        expected.setCommandDetails(testCommand.toString());

        Mockito.when(twitter.getAccountSettings()).thenReturn(settings);
        Mockito.when(settings.getRateLimitStatus()).thenReturn(rateLimitStatus);
        Mockito.when(rateLimitStatus.getRemaining()).thenReturn(0);

        TsakResponse result = testCommand.execute(twitter);

        assertEquals(expected.getRemApiLimits(), result.getRemApiLimits());
        assertEquals(expected.getResponseData(), result.getResponseData());
        assertEquals(expected.getCommandDetails(), result.getCommandDetails());

    }

    @Test
    public void testCase_3() throws TwitterException {

        CommandDumpAvailableTrends testCommand = new CommandDumpAvailableTrends();
        testCommand.setHelp(true);
        testCommand.setOutputFile(testOutput);

        TsakResponse expected = new TsakResponse(-1, locationsList);
        expected.setCommandDetails(testCommand.toString());

        Mockito.when(twitter.getAvailableTrends()).thenReturn(locationsList);

        TsakResponse result = testCommand.execute(twitter);

        assertEquals(expected.getResponseData(), result.getResponseData());
        assertEquals(expected.getCommandDetails(), result.getCommandDetails());
    }

    @Test
    public void testCase_4() throws TwitterException {

        CommandDumpBlockList testCommand = new CommandDumpBlockList();
        testCommand.setHelp(true);
        testCommand.setOutputFile(testOutput);

        TsakResponse expected = new TsakResponse(0, blockList);
        expected.setCommandDetails(testCommand.toString());

        Mockito.when(twitter.getBlocksList()).thenReturn(blockList);
        Mockito.when(blockList.getRateLimitStatus()).thenReturn(rateLimitStatus);
        Mockito.when(rateLimitStatus.getRemaining()).thenReturn(0);

        TsakResponse result = testCommand.execute(twitter);

        assertEquals(expected.getRemApiLimits(), result.getRemApiLimits());
        assertEquals(expected.getResponseData(), result.getResponseData());
        assertEquals(expected.getCommandDetails(), result.getCommandDetails());

    }

    @Test
    public void testCase_5() throws TwitterException {

    }

    @Test
    public void testCase_6() throws TwitterException {

        CommandDumpFavourites testCommand = new CommandDumpFavourites();
        testCommand.setHelp(true);
        testCommand.setOutputFile(testOutput);

        TsakResponse expected = new TsakResponse(0, statusList);
        expected.setCommandDetails(testCommand.toString());

        Mockito.when(twitter.getFavorites()).thenReturn(statusList);
        Mockito.when(statusList.getRateLimitStatus()).thenReturn(rateLimitStatus);
        Mockito.when(rateLimitStatus.getRemaining()).thenReturn(0);

        TsakResponse result = testCommand.execute(twitter);

        assertEquals(expected.getRemApiLimits(), result.getRemApiLimits());
        assertEquals(expected.getResponseData(), result.getResponseData());
        assertEquals(expected.getCommandDetails(), result.getCommandDetails());

    }

    @Test
    public void testCase_7() throws TwitterException {

        List<PagableResponseList<User>> followersList = new ArrayList<PagableResponseList<User>>();
        followersList.add(userPagableList);

        CommandDumpFollowersList testCommand = new CommandDumpFollowersList();
        testCommand.setHelp(true);
        testCommand.setOutputFile(testOutput);
        testCommand.setLimit(testLimit);
        testCommand.setUserId(testUserId);

        TsakResponse expected = new TsakResponse(0, followersList);
        expected.setCommandDetails(testCommand.toString());

        Mockito.when(twitter.getFollowersList(testUserId, -1)).thenReturn(userPagableList);
        Mockito.when(userPagableList.getRateLimitStatus()).thenReturn(rateLimitStatus);
        Mockito.when(userPagableList.getNextCursor()).thenReturn(0L);
        Mockito.when(rateLimitStatus.getRemaining()).thenReturn(0);

        TsakResponse result = testCommand.execute(twitter);

        assertEquals(expected.getRemApiLimits(), result.getRemApiLimits());
        assertEquals(expected.getResponseData(), result.getResponseData());
        assertEquals(expected.getCommandDetails(), result.getCommandDetails());

    }

    @Test
    public void testCase_8() throws TwitterException {

        List<IDs> friendsIDsCollection = new ArrayList<IDs>();
        friendsIDsCollection.add(ids);

        CommandDumpFriendIDs testCommand = new CommandDumpFriendIDs();
        testCommand.setHelp(true);
        testCommand.setOutputFile(testOutput);
        testCommand.setLimit(testLimit);
        testCommand.setUserId(testUserId);

        TsakResponse expected = new TsakResponse(0, friendsIDsCollection);
        expected.setCommandDetails(testCommand.toString());

        Mockito.when(twitter.getFriendsIDs(testUserId, -1)).thenReturn(ids);
        Mockito.when(ids.getRateLimitStatus()).thenReturn(rateLimitStatus);
        Mockito.when(userPagableList.getNextCursor()).thenReturn(0L);
        Mockito.when(rateLimitStatus.getRemaining()).thenReturn(0);

        TsakResponse result = testCommand.execute(twitter);

        assertEquals(expected.getRemApiLimits(), result.getRemApiLimits());
        assertEquals(expected.getResponseData(), result.getResponseData());
        assertEquals(expected.getCommandDetails(), result.getCommandDetails());

    }

    @Test
    public void testCase_9() throws TwitterException {

        List<PagableResponseList<User>> friendList = new ArrayList<PagableResponseList<User>>();
        friendList.add(userPagableList);

        CommandDumpFriendsList testCommand = new CommandDumpFriendsList();
        testCommand.setHelp(true);
        testCommand.setOutputFile(testOutput);
        testCommand.setLimit(testLimit);
        testCommand.setUserId(testUserId);

        TsakResponse expected = new TsakResponse(0, friendList);
        expected.setCommandDetails(testCommand.toString());

        Mockito.when(twitter.getFriendsList(testUserId, -1)).thenReturn(userPagableList);
        Mockito.when(userPagableList.getRateLimitStatus()).thenReturn(rateLimitStatus);
        Mockito.when(userPagableList.getNextCursor()).thenReturn(0L);
        Mockito.when(rateLimitStatus.getRemaining()).thenReturn(0);

        TsakResponse result = testCommand.execute(twitter);

        assertEquals(expected.getRemApiLimits(), result.getRemApiLimits());
        assertEquals(expected.getResponseData(), result.getResponseData());
        assertEquals(expected.getCommandDetails(), result.getCommandDetails());

    }

    @Test
    public void testCase_10() throws TwitterException {

        CommandDumpGeoDetails testCommand = new CommandDumpGeoDetails();
        testCommand.setHelp(true);
        testCommand.setOutputFile(testOutput);
        testCommand.setPlaceId(testPlaceId);

        TsakResponse expected = new TsakResponse(0, place);
        expected.setCommandDetails(testCommand.toString());

        Mockito.when(twitter.getGeoDetails(testPlaceId)).thenReturn(place);
        Mockito.when(place.getRateLimitStatus()).thenReturn(rateLimitStatus);
        Mockito.when(rateLimitStatus.getRemaining()).thenReturn(0);

        TsakResponse result = testCommand.execute(twitter);

        assertEquals(expected.getRemApiLimits(), result.getRemApiLimits());
        assertEquals(expected.getResponseData(), result.getResponseData());
        assertEquals(expected.getCommandDetails(), result.getCommandDetails());

    }

    @Test
    public void testCase_11() throws TwitterException {

        CommandDumpHomeTimeLine testCommand = new CommandDumpHomeTimeLine();
        testCommand.setHelp(true);
        testCommand.setOutputFile(testOutput);

        TsakResponse expected = new TsakResponse(0, statusList);
        expected.setCommandDetails(testCommand.toString());

        Mockito.when(twitter.getHomeTimeline()).thenReturn(statusList);
        Mockito.when(statusList.getRateLimitStatus()).thenReturn(rateLimitStatus);
        Mockito.when(rateLimitStatus.getRemaining()).thenReturn(0);

        TsakResponse result = testCommand.execute(twitter);

        assertEquals(expected.getRemApiLimits(), result.getRemApiLimits());
        assertEquals(expected.getResponseData(), result.getResponseData());
        assertEquals(expected.getCommandDetails(), result.getCommandDetails());

    }

    /* CommandDumpIncomingFriendships */
    @Test
    public void testCase_12() throws TwitterException {

        List<IDs> IncomingFriendshipsCollection = new ArrayList<IDs>();
        IncomingFriendshipsCollection.add(ids);

        CommandDumpIncomingFriendships testCommand = new CommandDumpIncomingFriendships();
        testCommand.setHelp(true);
        testCommand.setOutputFile(testOutput);
        testCommand.setLimit(testLimit);

        TsakResponse expected = new TsakResponse(0, IncomingFriendshipsCollection);
        expected.setCommandDetails(testCommand.toString());

        Mockito.when(twitter.getIncomingFriendships(-1)).thenReturn(ids);
        Mockito.when(ids.getNextCursor()).thenReturn(0L);
        Mockito.when(ids.getRateLimitStatus()).thenReturn(rateLimitStatus);
        Mockito.when(rateLimitStatus.getRemaining()).thenReturn(0);

        TsakResponse result = testCommand.execute(twitter);

        assertEquals(expected.getRemApiLimits(), result.getRemApiLimits());
        assertEquals(expected.getResponseData(), result.getResponseData());
        assertEquals(expected.getCommandDetails(), result.getCommandDetails());

    }

    /* CommandDumpListStatuses */
    @Test
    public void testCase_13() throws Exception {

    }

    /* CommandDumpMemberSuggestions */
    @Test
    public void testCase_14() throws Exception {

        CommandDumpMemberSuggestions testCommand = new CommandDumpMemberSuggestions();
        testCommand.setHelp(true);
        testCommand.setOutputFile(testOutput);
        testCommand.setSlug(testSlug);

        TsakResponse expected = new TsakResponse(0, userRList);
        expected.setCommandDetails(testCommand.toString());

        Mockito.when(twitter.getMemberSuggestions(testSlug)).thenReturn(userRList);
        Mockito.when(userRList.getRateLimitStatus()).thenReturn(rateLimitStatus);
        Mockito.when(rateLimitStatus.getRemaining()).thenReturn(0);

        TsakResponse result = testCommand.execute(twitter);

        assertEquals(expected.getRemApiLimits(), result.getRemApiLimits());
        assertEquals(expected.getResponseData(), result.getResponseData());
        assertEquals(expected.getCommandDetails(), result.getCommandDetails());

    }

    /* CommandDumpMentionsTimeLine */
    @Test
    public void testCase_15() throws Exception {

        CommandDumpMentionsTimeLine testCommand = new CommandDumpMentionsTimeLine();
        testCommand.setHelp(true);
        testCommand.setOutputFile(testOutput);

        TsakResponse expected = new TsakResponse(0, statusList);
        expected.setCommandDetails(testCommand.toString());

        Mockito.when(twitter.getMentionsTimeline()).thenReturn(statusList);
        Mockito.when(statusList.getRateLimitStatus()).thenReturn(rateLimitStatus);
        Mockito.when(rateLimitStatus.getRemaining()).thenReturn(0);

        TsakResponse result = testCommand.execute(twitter);

        assertEquals(expected.getRemApiLimits(), result.getRemApiLimits());
        assertEquals(expected.getResponseData(), result.getResponseData());
        assertEquals(expected.getCommandDetails(), result.getCommandDetails());

    }

    /* CommandDumpMentionsTimeLine */
    @Test
    public void testCase_16() throws Exception {

        List<IDs> mutesIDsCollection = new ArrayList<IDs>();
        mutesIDsCollection.add(ids);

        CommandDumpMutesIDs testCommand = new CommandDumpMutesIDs();
        testCommand.setHelp(true);
        testCommand.setOutputFile(testOutput);
        testCommand.setLimit(testLimit);

        TsakResponse expected = new TsakResponse(0, mutesIDsCollection);
        expected.setCommandDetails(testCommand.toString());

        Mockito.when(twitter.getMutesIDs(-1)).thenReturn(ids);
        Mockito.when(ids.getRateLimitStatus()).thenReturn(rateLimitStatus);
        Mockito.when(rateLimitStatus.getRemaining()).thenReturn(0);

        TsakResponse result = testCommand.execute(twitter);

        assertEquals(expected.getRemApiLimits(), result.getRemApiLimits());
        assertEquals(expected.getResponseData(), result.getResponseData());
        assertEquals(expected.getCommandDetails(), result.getCommandDetails());

    }

    /* CommandDumpMutesIDs */
    @Test
    public void testCase_17() throws Exception {

        List<PagableResponseList<User>> MutesListCollection = new ArrayList<PagableResponseList<User>>();
        MutesListCollection.add(userPagableList);

        CommandDumpMutesList testCommand = new CommandDumpMutesList();
        testCommand.setHelp(true);
        testCommand.setOutputFile(testOutput);
        testCommand.setLimit(testLimit);

        TsakResponse expected = new TsakResponse(0, MutesListCollection);
        expected.setCommandDetails(testCommand.toString());

        Mockito.when(twitter.getMutesList(-1)).thenReturn(userPagableList);
        Mockito.when(userPagableList.getRateLimitStatus()).thenReturn(rateLimitStatus);
        Mockito.when(rateLimitStatus.getRemaining()).thenReturn(0);

        TsakResponse result = testCommand.execute(twitter);

        assertEquals(expected.getRemApiLimits(), result.getRemApiLimits());
        assertEquals(expected.getResponseData(), result.getResponseData());
        assertEquals(expected.getCommandDetails(), result.getCommandDetails());

    }

    /* CommandDumpOutgoingFriendships */
    @Test
    public void testCase_20() throws Exception {

        List<IDs> outGoingFriendshipsCollection = new ArrayList<IDs>();
        outGoingFriendshipsCollection.add(ids);

        CommandDumpOutgoingFriendships testCommand = new CommandDumpOutgoingFriendships();
        testCommand.setHelp(true);
        testCommand.setOutputFile(testOutput);
        testCommand.setLimit(testLimit);

        TsakResponse expected = new TsakResponse(0, outGoingFriendshipsCollection);
        expected.setCommandDetails(testCommand.toString());

        Mockito.when(twitter.getOutgoingFriendships(-1)).thenReturn(ids);
        Mockito.when(ids.getRateLimitStatus()).thenReturn(rateLimitStatus);
        Mockito.when(rateLimitStatus.getRemaining()).thenReturn(0);

        TsakResponse result = testCommand.execute(twitter);

        assertEquals(expected.getRemApiLimits(), result.getRemApiLimits());
        assertEquals(expected.getResponseData(), result.getResponseData());
        assertEquals(expected.getCommandDetails(), result.getCommandDetails());

    }

    /* CommandDumpOwnRetweets */
    @Test
    public void testCase_21() throws Exception {

        CommandDumpOwnRetweets testCommand = new CommandDumpOwnRetweets();
        testCommand.setHelp(true);
        testCommand.setOutputFile(testOutput);

        TsakResponse expected = new TsakResponse(0, statusList);
        expected.setCommandDetails(testCommand.toString());

        Mockito.when(twitter.getRetweetsOfMe()).thenReturn(statusList);
        Mockito.when(statusList.getRateLimitStatus()).thenReturn(rateLimitStatus);
        Mockito.when(rateLimitStatus.getRemaining()).thenReturn(0);

        TsakResponse result = testCommand.execute(twitter);

        assertEquals(expected.getRemApiLimits(), result.getRemApiLimits());
        assertEquals(expected.getResponseData(), result.getResponseData());
        assertEquals(expected.getCommandDetails(), result.getCommandDetails());

    }

    /* CommandDumpPlaceTrends */
    @Test
    public void testCase_22() throws Exception {

        CommandDumpPlaceTrends testCommand = new CommandDumpPlaceTrends();
        testCommand.setHelp(true);
        testCommand.setOutputFile(testOutput);
        testCommand.setWoeId(testWoeId);

        TsakResponse expected = new TsakResponse(0, trends);
        expected.setCommandDetails(testCommand.toString());

        Mockito.when(twitter.getPlaceTrends(testWoeId)).thenReturn(trends);
        Mockito.when(trends.getRateLimitStatus()).thenReturn(rateLimitStatus);
        Mockito.when(rateLimitStatus.getRemaining()).thenReturn(0);

        TsakResponse result = testCommand.execute(twitter);

        assertEquals(expected.getRemApiLimits(), result.getRemApiLimits());
        assertEquals(expected.getResponseData(), result.getResponseData());
        assertEquals(expected.getCommandDetails(), result.getCommandDetails());

    }

    /* CommandDumpRetweeters */
    @Test
    public void testCase_23() throws Exception {

        List<IDs> retweetersIDs = new ArrayList<IDs>();
        retweetersIDs.add(ids);

        CommandDumpRetweeters testCommand = new CommandDumpRetweeters();
        testCommand.setHelp(true);
        testCommand.setOutputFile(testOutput);
        testCommand.setStatusId(testStatusId);

        TsakResponse expected = new TsakResponse(0, retweetersIDs);
        expected.setCommandDetails(testCommand.toString());

        Mockito.when(twitter.getRetweeterIds(testStatusId, -1)).thenReturn(ids);
        Mockito.when(ids.getRateLimitStatus()).thenReturn(rateLimitStatus);
        Mockito.when(rateLimitStatus.getRemaining()).thenReturn(0);

        TsakResponse result = testCommand.execute(twitter);

        assertEquals(expected.getRemApiLimits(), result.getRemApiLimits());
        assertEquals(expected.getResponseData(), result.getResponseData());
        assertEquals(expected.getCommandDetails(), result.getCommandDetails());

    }

    /* CommandDumpSavedSearches */
    @Test
    public void testCase_24() throws Exception {

        CommandDumpSavedSearches testCommand = new CommandDumpSavedSearches();
        testCommand.setHelp(true);
        testCommand.setOutputFile(testOutput);

        TsakResponse expected = new TsakResponse(0, savedSearchResponseList);
        expected.setCommandDetails(testCommand.toString());

        Mockito.when(twitter.getSavedSearches()).thenReturn(savedSearchResponseList);
        Mockito.when(savedSearchResponseList.getRateLimitStatus()).thenReturn(rateLimitStatus);
        Mockito.when(rateLimitStatus.getRemaining()).thenReturn(0);

        TsakResponse result = testCommand.execute(twitter);

        assertEquals(expected.getRemApiLimits(), result.getRemApiLimits());
        assertEquals(expected.getResponseData(), result.getResponseData());
        assertEquals(expected.getCommandDetails(), result.getCommandDetails());

    }

     /* CommandDumpSimilarPlaces */
     @Test
     public void testCase_25() throws Exception {
    
     }
    /* CommandDumpStatus */
    @Test
    public void testCase_26() throws Exception {

        CommandDumpStatus testCommand = new CommandDumpStatus();
        testCommand.setHelp(true);
        testCommand.setOutputFile(testOutput);
        testCommand.setStatusId(testStatusId);

        TsakResponse expected = new TsakResponse(0, status);
        expected.setCommandDetails(testCommand.toString());

        Mockito.when(twitter.showStatus(testStatusId)).thenReturn(status);
        Mockito.when(status.getRateLimitStatus()).thenReturn(rateLimitStatus);
        Mockito.when(rateLimitStatus.getRemaining()).thenReturn(0);

        TsakResponse result = testCommand.execute(twitter);

        assertEquals(expected.getRemApiLimits(), result.getRemApiLimits());
        assertEquals(expected.getResponseData(), result.getResponseData());
        assertEquals(expected.getCommandDetails(), result.getCommandDetails());

    }

    /* CommandDumpSuggestedUserCats */
    @Test
    public void testCase_27() throws Exception {

        CommandDumpSuggestedUserCats testCommand = new CommandDumpSuggestedUserCats();
        testCommand.setHelp(true);
        testCommand.setOutputFile(testOutput);

        TsakResponse expected = new TsakResponse(0, categoryResponseList);
        expected.setCommandDetails(testCommand.toString());

        Mockito.when(twitter.getSuggestedUserCategories()).thenReturn(categoryResponseList);
        Mockito.when(categoryResponseList.getRateLimitStatus()).thenReturn(rateLimitStatus);
        Mockito.when(rateLimitStatus.getRemaining()).thenReturn(0);

        TsakResponse result = testCommand.execute(twitter);

        assertEquals(expected.getRemApiLimits(), result.getRemApiLimits());
        assertEquals(expected.getResponseData(), result.getResponseData());
        assertEquals(expected.getCommandDetails(), result.getCommandDetails());

    }

    /* CommandDumpTweets */
     @Test
     public void testCase_28() throws Exception {
    
     }
     
    /* CommandDumpSuggestedUserCats */
    @Test
    public void testCase_29() throws Exception {

        CommandDumpSuggestedUserCats testCommand = new CommandDumpSuggestedUserCats();
        testCommand.setHelp(true);
        testCommand.setOutputFile(testOutput);

        TsakResponse expected = new TsakResponse(0, categoryResponseList);
        expected.setCommandDetails(testCommand.toString());

        Mockito.when(twitter.getSuggestedUserCategories()).thenReturn(categoryResponseList);
        Mockito.when(categoryResponseList.getRateLimitStatus()).thenReturn(rateLimitStatus);
        Mockito.when(rateLimitStatus.getRemaining()).thenReturn(0);

        TsakResponse result = testCommand.execute(twitter);

        assertEquals(expected.getRemApiLimits(), result.getRemApiLimits());
        assertEquals(expected.getResponseData(), result.getResponseData());
        assertEquals(expected.getCommandDetails(), result.getCommandDetails());

    }

    /* CommandDumpTweets */
    @Test
    public void testCase_30() throws Exception {

    }

    /* CommandDumpUserListMembers */
    @Test
    public void testCase_31() throws Exception {
        List<PagableResponseList<User>> ListMembersCollection = new ArrayList<PagableResponseList<User>>();
        ListMembersCollection.add(userPagableList);
        CommandDumpUserListMembers testCommand = new CommandDumpUserListMembers();
        testCommand.setHelp(true);
        testCommand.setOutputFile(testOutput);
        testCommand.setLimit(testLimit);
        testCommand.setListId(testListId);

        TsakResponse expected = new TsakResponse(0, ListMembersCollection);
        expected.setCommandDetails(testCommand.toString());

        Mockito.when(twitter.getUserListMembers(testListId, -1)).thenReturn(userPagableList);
        Mockito.when(userPagableList.getRateLimitStatus()).thenReturn(rateLimitStatus);
        Mockito.when(rateLimitStatus.getRemaining()).thenReturn(0);

        TsakResponse result = testCommand.execute(twitter);

        assertEquals(expected.getRemApiLimits(), result.getRemApiLimits());
        assertEquals(expected.getResponseData(), result.getResponseData());
        assertEquals(expected.getCommandDetails(), result.getCommandDetails());

    }

    /* CommandDumpUserListMemberships */
    @Test
    public void testCase_32() throws Exception {
        List<PagableResponseList<UserList>> listMemberships = new ArrayList<PagableResponseList<UserList>>();
        listMemberships.add(userPRLists);
        CommandDumpUserListMemberships testCommand = new CommandDumpUserListMemberships();
        testCommand.setHelp(true);
        testCommand.setOutputFile(testOutput);
        testCommand.setLimit(testLimit);
        testCommand.setUserId(testUserId);

        TsakResponse expected = new TsakResponse(0, listMemberships);
        expected.setCommandDetails(testCommand.toString());

        Mockito.when(twitter.getUserListMemberships(testListId, -1)).thenReturn(userPRLists);
        Mockito.when(userPRLists.getRateLimitStatus()).thenReturn(rateLimitStatus);
        Mockito.when(rateLimitStatus.getRemaining()).thenReturn(0);

        TsakResponse result = testCommand.execute(twitter);

        assertEquals(expected.getRemApiLimits(), result.getRemApiLimits());
        assertEquals(expected.getResponseData(), result.getResponseData());
        assertEquals(expected.getCommandDetails(), result.getCommandDetails());

    }

    /* CommandDumpUserListSubscribers */
    @Test
    public void testCase_33() throws Exception {
        List<PagableResponseList<User>> listSubscribers = new ArrayList<PagableResponseList<User>>();
        listSubscribers.add(userPagableList);
        CommandDumpUserListSubscribers testCommand = new CommandDumpUserListSubscribers();
        testCommand.setHelp(true);
        testCommand.setOutputFile(testOutput);
        testCommand.setListId(testListId);
        testCommand.setLimit(testLimit);

        TsakResponse expected = new TsakResponse(0, listSubscribers);
        expected.setCommandDetails(testCommand.toString());

        Mockito.when(twitter.getUserListSubscribers(testListId, -1)).thenReturn(userPagableList);
        Mockito.when(userPagableList.getRateLimitStatus()).thenReturn(rateLimitStatus);
        Mockito.when(rateLimitStatus.getRemaining()).thenReturn(0);

        TsakResponse result = testCommand.execute(twitter);

        assertEquals(expected.getRemApiLimits(), result.getRemApiLimits());
        assertEquals(expected.getResponseData(), result.getResponseData());
        assertEquals(expected.getCommandDetails(), result.getCommandDetails());

    }

    /* CommandDumpUserListSubscriptions */
    @Test
    public void testCase_34() throws Exception {
        List<PagableResponseList<UserList>> listSubscriptions = new ArrayList<PagableResponseList<UserList>>();
        listSubscriptions.add(userPRLists);
        CommandDumpUserListSubscriptions testCommand = new CommandDumpUserListSubscriptions();
        testCommand.setHelp(true);
        testCommand.setOutputFile(testOutput);
        testCommand.setScreenName(testUserName);
        testCommand.setLimit(testLimit);

        TsakResponse expected = new TsakResponse(0, listSubscriptions);
        expected.setCommandDetails(testCommand.toString());

        Mockito.when(twitter.getUserListSubscriptions(testUserName, -1)).thenReturn(userPRLists);
        Mockito.when(userPRLists.getRateLimitStatus()).thenReturn(rateLimitStatus);
        Mockito.when(rateLimitStatus.getRemaining()).thenReturn(0);

        TsakResponse result = testCommand.execute(twitter);

        assertEquals(expected.getRemApiLimits(), result.getRemApiLimits());
        assertEquals(expected.getResponseData(), result.getResponseData());
        assertEquals(expected.getCommandDetails(), result.getCommandDetails());

    }

    /* CommandDumpUserSuggestions */
    @Test
    public void testCase_35() throws Exception {

        CommandDumpUserSuggestions testCommand = new CommandDumpUserSuggestions();
        testCommand.setHelp(true);
        testCommand.setOutputFile(testOutput);
        testCommand.setSlug(testSlug);

        TsakResponse expected = new TsakResponse(0, userPagableList);
        expected.setCommandDetails(testCommand.toString());

        Mockito.when(twitter.getUserSuggestions(testSlug)).thenReturn(userPagableList);
        Mockito.when(userPagableList.getRateLimitStatus()).thenReturn(rateLimitStatus);
        Mockito.when(rateLimitStatus.getRemaining()).thenReturn(0);

        TsakResponse result = testCommand.execute(twitter);

        assertEquals(expected.getRemApiLimits(), result.getRemApiLimits());
        assertEquals(expected.getResponseData(), result.getResponseData());
        assertEquals(expected.getCommandDetails(), result.getCommandDetails());

    }

    /* CommandDumpUserSuggestions */
    @Test
    public void testCase_36() throws Exception {

        CommandDumpUserSuggestions testCommand = new CommandDumpUserSuggestions();
        testCommand.setHelp(true);
        testCommand.setOutputFile(testOutput);
        testCommand.setSlug(testSlug);

        TsakResponse expected = new TsakResponse(0, userPagableList);
        expected.setCommandDetails(testCommand.toString());

        Mockito.when(twitter.getUserSuggestions(testSlug)).thenReturn(userPagableList);
        Mockito.when(userPagableList.getRateLimitStatus()).thenReturn(rateLimitStatus);
        Mockito.when(rateLimitStatus.getRemaining()).thenReturn(0);

        TsakResponse result = testCommand.execute(twitter);

        assertEquals(expected.getRemApiLimits(), result.getRemApiLimits());
        assertEquals(expected.getResponseData(), result.getResponseData());
        assertEquals(expected.getCommandDetails(), result.getCommandDetails());

    }

    /* CommandDumpUserTimeLine */
    @Test
    public void testCase_37() throws Exception {

    }

    /* CommandLookupFriendShip */
    @Test
    public void testCase_38() throws Exception {

    }

    /* CommandSearchPlace */
    @Test
    public void testCase_39() throws Exception {
     
    }

    /* CommandSearchUsers */
    @Test
    public void testCase40() throws Exception {
        List<ResponseList<User>> usersCollection = new ArrayList<ResponseList<User>>();
        usersCollection.add(userRList);
        CommandSearchUsers testCommand = new CommandSearchUsers();
        testCommand.setHelp(true);
        testCommand.setOutputFile(testOutput);
        testCommand.setKeywords(testKeywords);

        TsakResponse expected = new TsakResponse(0, usersCollection);
        expected.setCommandDetails(testCommand.toString());

        Mockito.when(twitter.searchUsers(testKeywords, 1)).thenReturn(userRList);
        Mockito.when(userRList.getRateLimitStatus()).thenReturn(rateLimitStatus);
        Mockito.when(rateLimitStatus.getRemaining()).thenReturn(0);

        TsakResponse result = testCommand.execute(twitter);

        assertEquals(expected.getRemApiLimits(), result.getRemApiLimits());
        assertEquals(expected.getResponseData(), result.getResponseData());
        assertEquals(expected.getCommandDetails(), result.getCommandDetails());

    }

    /* CommandShowFriendShip */
    @Test
    public void testCase41() throws Exception {

        CommandShowFriendShip testCommand = new CommandShowFriendShip();
        testCommand.setHelp(true);
        testCommand.setOutputFile(testOutput);
        testCommand.setSource(testSource);
        testCommand.setTarget(testTarget);

        TsakResponse expected = new TsakResponse(0, relationship);
        expected.setCommandDetails(testCommand.toString());

        Mockito.when(twitter.showFriendship(testSource, testTarget)).thenReturn(relationship);
        Mockito.when(relationship.getRateLimitStatus()).thenReturn(rateLimitStatus);
        Mockito.when(rateLimitStatus.getRemaining()).thenReturn(0);

        TsakResponse result = testCommand.execute(twitter);

        assertEquals(expected.getRemApiLimits(), result.getRemApiLimits());
        assertEquals(expected.getResponseData(), result.getResponseData());
        assertEquals(expected.getCommandDetails(), result.getCommandDetails());

    }
}