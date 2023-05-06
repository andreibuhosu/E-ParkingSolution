package acb54.eparkingsolution;


import acb54.eparkingsolution.controller.StatisticsController;
import acb54.eparkingsolution.model.User;
import acb54.eparkingsolution.repository.*;
import acb54.eparkingsolution.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.security.Principal;
import java.util.ArrayList;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


@WebMvcTest(StatisticsController.class)
public class StatisticsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @MockBean
    private TransactionRepository transactionRepository;

    @MockBean
    private CardRepository cardRepository;

    @MockBean
    private CarParkRepository carParkRepository;

    @MockBean
    private ParkingSpaceRepository parkingSpaceRepository;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private Principal principal;

    @Test
    public void testParkingOwnerStatistics() throws Exception {
        // Prepare test data
        String email = "test@example.com";
        User user = new User();
        user.setCarParks(new ArrayList<>());
        user.setTransactions(new ArrayList<>());

        // Mock the behavior of the userService and principal
        when(principal.getName()).thenReturn(email);
        when(userService.findByUsername(email)).thenReturn(user);

        // Perform the GET request and check the response
        mockMvc.perform(get("/parkingOwnerStatistics")
                        .principal(principal)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(view().name("statisticsParkingOwner"))
                .andExpect(model().attributeExists("totalCarParks", "totalParkingSpaces", "percentageWithDisabledSpaces",
                        "averagePriceByCarPark", "overallAveragePrice", "totalRevenue", "mostFrequentLicensePlate",
                        "mostBookedLicensePlate", "mostBookedLicensePlateCount", "percentageOfDisabledSpaces",
                        "highestTransactionAmount", "busiestDayOfWeek", "averageTransactionDuration"));
    }



}

