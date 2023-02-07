import androidx.compose.animation.core.animateIntOffsetAsState
import androidx.compose.animation.core.tween
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.unit.IntOffset

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CalendarView(isMyCalendar: Boolean) {
//    val state by viewModel.state.collectAsStateWithLifecycle()

    val bottomSheetState = rememberBottomSheetState(initialValue = BottomSheetValue.Collapsed)

    val coroutineScope = rememberCoroutineScope()

//    val sheetHeight by animateDpAsState(
//        targetValue = if (state.isStatsExpanded) 200.dp else 100.dp,
//        animationSpec = tween(700)
//    )

    var isCurrentMonthVisible by remember { mutableStateOf(true) }

    var fabAdditionalOffset by remember { mutableStateOf(0) }

    val fabOffset by animateIntOffsetAsState(
        targetValue = IntOffset(
            x = 0,
            y = if (isCurrentMonthVisible) -100 else 200 + fabAdditionalOffset
        ),
        animationSpec = tween(700)
    )

//    LaunchedEffect(key1 = true) {
//        viewModel.event.collect { event ->
//            when (event) {
//                is CalendarUIEvent.ErrorLoading -> {} // TODO
//            }
//        }
//    }
//
//    LaunchedEffect(bottomSheetState.isExpanded) {
//        viewModel.onEvent(CalendarEvent.ToggleStatistic(bottomSheetState.isExpanded))
//    }
//
//    LaunchedEffect(key1 = true) {
//        viewModel.animateScrollEvent.collect { bottomSheetState.collapse() }
//    }

//    BottomSheetScaffold(
//        topBar = {
//            if (isMyCalendar) TopAppBar {
//
//            } else null
//        },
//        scaffoldState = rememberBottomSheetScaffoldState(bottomSheetState = bottomSheetState),
//        sheetPeekHeight = sheetHeight,
//        sheetShape = MaterialTheme.shapes.medium.copy(
//            bottomEnd = CornerSize(0),
//            bottomStart = CornerSize(0)
//        ),
//        sheetContent = BottomSheet(
//            statistic = state.statistic,
//            onSizeMeasured = { if (fabAdditionalOffset < it) fabAdditionalOffset = it },
//            onStatClicked = viewModel::onEvent
//        ),
//        floatingActionButton = {
//            FloatingActionButton(
//                shape = CircleShape,
//                onClick = { viewModel.onEvent(CalendarEvent.BackToCurrentDate) },
//                modifier = Modifier.offset { fabOffset }
//            ) {
//                Icon(
//                    imageVector = Icons.Default.ArrowDownward,
//                    contentDescription = stringResource(id = R.string.back_to_date_button)
//                )
//            }
//        },
//    ) { paddingValues ->

//        CalendarCustomView(
//            onDayClick = remember {
//                {
//                    if (isMyCalendar) {
//                        //TODO
//                    } else Unit
//                }
//            },
//            calendarData = remember { { state.calendarData } },
//            scrollToDateIndex = remember { viewModel.scrollEvent },
//            animateScrollToDateIndex = remember { viewModel.animateScrollEvent },
//            onScrollCompleted = remember { {/*TODO*/ } },
//            isCurrentMonthVisible = remember { { isCurrentMonthVisible = !it } },
//            modifier = Modifier.padding(paddingValues)
//        )
//    }
}