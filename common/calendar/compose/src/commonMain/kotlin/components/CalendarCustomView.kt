package components

//
//@Composable
//fun CalendarCustomView(
//    onDayClick: (LocalDate) -> Unit,
//    calendarData: ()->List<MonthData>,
//    modifier: Modifier = Modifier,
//    scrollToDateIndex: Flow<Int>,
//    animateScrollToDateIndex: SharedFlow<Int>,
//    isCurrentMonthVisible: (Boolean) -> Unit,
//    onScrollCompleted: () -> Unit
//) {
//    val listState = rememberLazyListState()
//
//    val currentMonthIndex by remember(calendarData()) {
//        val data = calendarData()
//        val calendarMonth = data
//            .find { monthData ->
//                monthData.weeks.flatMap { week ->
//                    week.map { it?.date }
//                }.contains(LocalDate.now())
//            }
//            ?: return@remember mutableStateOf(if (data.size > 1) data.size - 1 else 0)
//
//        mutableStateOf(data.indexOf(calendarMonth))
//    }
//
//    LaunchedEffect(listState) {
//        snapshotFlow { listState.firstVisibleItemIndex }
//            .map { it >= currentMonthIndex }
//            .distinctUntilChanged()
//            .collect { isCurrentMonthVisible(it) }
//    }
//
//    LaunchedEffect(key1 = true) {
//        scrollToDateIndex.collect {
//            listState.scrollToItem(it)
//            onScrollCompleted()
//        }
//    }
//
//    LaunchedEffect(key1 = true) {
//        animateScrollToDateIndex.collect { listState.animateScrollToItem(it) }
//    }
//
//    LazyColumn(
//        modifier = modifier,
//        state = listState,
//        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
//    ) {
//        items(
//            items = calendarData(),
//            key = { it.yearMonth }
//        ) { calendarMonth ->
//            ElevatedCard(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(vertical = 8.dp)
//            ) {
//                CalendarMonthItem(
//                    monthData = calendarMonth,
//                    onDayClick = onDayClick,
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(8.dp)
//                )
//            }
//        }
//    }
//}